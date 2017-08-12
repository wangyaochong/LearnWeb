var message = require("./messages")
// import  Button from "./button";
import Kitten from "./image";
import UppsalaJs from "./uppsalajs";
import {multiply} from "./mathStuff";
import  $ from "jquery";

var style = require("./style/globalStyle.css")
// var newMessage= () => (`<p> ${message.hi}  &&  ${message.event}</p>`)
// var newMessage=()=>(Button.button)
// var newMessage=()=>( multiply(3,3) );
var newMessage = () => (`<p>${message.hi} ${message.event} ${Kitten} ${UppsalaJs}</p>`)
var newMessage = () => (`
<div class="${style.box}">
    DEV:${DEVELOPMENT.toString()}<br>
    PROD:${PRODUCTION.toString()}<br>
    </div>
`)
var app = document.getElementById("app");
app.innerHTML = newMessage();


$("#app").css("background-color","yellow");
// Button.attachEl();

app.innerHTML = `
<div id="menu">
<button id="loadPage1">loadPage1</button>
<button id="loadPage2">loadPage2</button>
<div id="content">
<h1>home</h1>
</div>
</div>
`;
document.getElementById("loadPage1").addEventListener('click',function () {
    System.import("./page1").then(pageModule=>{
        document.getElementById("content").innerHTML=pageModule.default;
    })
})
document.getElementById("loadPage2").addEventListener('click',function () {
    System.import("./page2").then(pageModule=>{
        document.getElementById("content").innerHTML=pageModule.default;
    });
})



if (DEVELOPMENT) {
    if (module.hot) {
        module.hot.accept();
    }
}


/////////////////////////////////////////////////////////////////////////////////
//以下代码是学习es6的，与webpack无关
//////////////--------Promise---------------------/////////////////////////////
var p1=Promise.resolve('Resolve Me');
p1.then(function (res) {
    //注意，这段代码比后续代码执行慢，所以在html最后显示
    document.write(`<br>${res}<br>`);
})
var p2=new Promise(function (resolve, reject) {
    setTimeout(function () {
        resolve("Resolve Me 2")
    },2000);
})

/*//这段代码执行会导致刷新网页
 p2.then(function (res) {
     document.write(`<br>${res}<br>`);
 })
 */

let randVal=6;
var p3=new Promise(function (resolve, reject) {
    if(randVal==6){
        resolve("Good Value");
    }else{
        reject("Bad Value");
    }
})
p3.then(function (res) {
    document.write(`<br> Good value : ${res}<br>`);
},function (err) {
    document.write(` <br>Bad value : ${err}<br>`);
})

var p4=new Promise(function (resolve, reject) {
    if(randVal>=18){
        throw new Error("not good");
    }else{
        resolve("good value");
    }
})
p4.then(function (res) {
    document.write(`<br> Good value : ${res}<br>`);
},function (err) {
    document.write(` <br>Bad value : ${err}<br>`);
})







//////////////---------Map---------/////////////////////
var randMap=new Map();
randMap.set('key1','random string');
randMap.set('key2',10);
document.write(`Key 1 : ${randMap.get("key1")}<br>`)
document.write(`Key 1 : ${randMap.get("key2")}<br>`)
document.write(`Map size: ${randMap.size}<br>`);
randMap.forEach(function (value, key) {
    document.write(`${key}:${value}<br>`)
})

///////////--------Set------///////////////////////
var randSet=new Set();
randSet.add(10);
randSet.add("word");
document.write(`Has 10: ${randSet.has(10)}<br>`)
document.write(`Set size: ${randSet.size}<br>`)
randSet.delete(10);

for(let val of randSet){
    document.write(`Set val : ${val}<br>`)
}


///////////-----Array------////////////////
let array1=Array.of(1,2,3,4);
let array2=Array.from("word");
let array3=Array.from(array1,(value)=>value*2);
document.write(`array2 : ${array2}<br>`);
for(let val of array3){
    document.write(`Array Val: ${val}<br>`)
}


////////////////---------Symbol--------//////////////////////////
let capital=Symbol("State capital");
let pennsylvania={};
pennsylvania[capital]="Harrisburg";
document.write(`Capital of pa : ${pennsylvania[capital]}<br> `);
document.write(`Symbol Capital : ${capital.toString()}<br> `);

let employNum=Symbol.for("Employee Number");
let bobSmith ={};
bobSmith[employNum]=10;
let sallyMarks={};
sallyMarks[employNum]=20;
document.write(`bobSmith : ${bobSmith[employNum]}<br> `);
document.write(`sallyMarks : ${sallyMarks[employNum]}<br> `);





/////////////----------Class------------/////////////////////////

class Mammal{
    constructor(name){
        this._name=name;
    }
    get name(){
        return this._name;
    }
    set name(name){
        this._name=name;
    }
    static makeMammal(name){
        return new Mammal(name);
    }
    getInfo(){
        return `${this.name} is a mamal`;
    }
}
let monkey= new Mammal('monkey');
monkey.name="monkey 2";
document.write(`Mammal 1 : ${monkey.name}<br>`);
let chip=Mammal.makeMammal('Chipper');
document.write(`Mammal 2 : ${chip.name}<br>`)

class Marsupial extends Mammal{
    constructor(name,hasPouch){
        super(name);
        this._hasPouch=hasPouch;
    }
    get hasPouch(){
        return this._hasPouch;
    }
    set hasPouch(hasPouch){
        this._hasPouch=hasPouch;
    }
    getInfo(){
        return `${this.name} is marsupial`;
    }
}
let kangaroo=new Marsupial("paul" ,true);
document.write(`It is ${kangaroo.hasPouch} that ${kangaroo.name} has a pouch<br>`);
document.write(`${chip.getInfo()}<br>`);
document.write(`${kangaroo.getInfo()}<br>`);
function getClass(classType){
    if(classType==1){
        return Mammal;
    }else{
        return Marsupial;
    }
}
class Koala extends getClass(2){
    constructor(name){
        super(name);
    }
}
let carl=new Koala('Carl');
document.write(`${carl.getInfo()}<br>`);



function createAnimal(name, owner) {
    return {
        name,owner,getInfo(){
            return `${this.name} is owned by ${this.owner}`;
        },
        address:{
            street:'123 main st',
            city:'beijing'
        }
    }
}
var spot =createAnimal('Spot',"Wangyaochong");
document.write(`${spot.getInfo()}<br>`)
document.write(`${spot.name} is at ${spot.address.street}<br>`)
document.write(`${Object.getOwnPropertyNames(spot).join(" ")} <br>`)

let {name,owner}=spot;
document.write(`Name : ${name}<br>`);
let {address}=spot;
document.write(`Address : ${address.street}<br>`);
let favNums=[2,3,6];
let [,,chaos]=favNums;
document.write(`Chaos : ${chaos}<br>`);
let [,...last2]=favNums;
document.write(`Last 2 Num : ${last2}<br>`);
let val1=1,val2=2;
[val1,val2]=[val2,val1];
document.write(`switched values : ${val1},${val2}<br>`);














if(true){
    let x=10;
    // var x=10;
    document.write(`x=${x} <br/>`)
}
// document.write("x= "+x)//如果是用let，外部无法访问
const PI=3.14159;
if(true){
    const PI=2.13;
    document.write(`PI=${PI}<br/>`);
}
document.write(`PI=${PI}<br/>`);

let fName="Derek";
let lName="Bananas";
document.write(`${fName} ${lName} <br>`)//es6的模版字符串
let num1=10;
let num2=5;
document.write(`10*5=${num1*num2} <br>`)
function doMath(strings, ...values) {
    document.write(strings+"<br>"+values+"<br>")
    if(strings[0]==="Add"){
        document.write(`${values[0]}+${values[1]}=${values[0]+values[1]} <br>`);
    }
    if(strings[0]==="Sub"){
        document.write(`${values[0]}-${values[1]}=${values[0]-values[1]} <br>`);
    }
}
doMath `Add${10} ${20}`;
doMath `Sub${10} ${20}`;
for(let c of fName){
    document.write(`${c}<br>`) ;
}
document.write("hello ".repeat(3)+"<br>")
document.write("hello ".startsWith("hel")+"<br>")
document.write("hello ".endsWith("llo")+"<br>")
document.write("hello ".includes("llo")+"<br>")

//多行字符串
let multilineStr="This is \
a multiline\
 string"
document.write(`${multilineStr}<br>`)

function getSum(num1=1,num2=2){
    document.write(`${num1}+${num2}=${num1+num2}<br>`);
    document.write(`${arguments[0]}+${arguments[1]}<br>`)
}
getSum(3);
function getSumMore(...values){
    let sum=0;
    for(let i=0,len=values.length;i<len;i++){
        sum+=values[i];
    }
    document.write(`The sum is ${sum}<br>`);
}
getSumMore(1,2,3,4);
let vals=[1,2,3,4];
getSumMore(...vals);

let differfent=(num1,num2)=>num1-num2;
document.write(`5-10=${differfent(5,10)}<br>`)
let mult=(num1,num2)=>{
    let product=num1*num2;
    document.write(`${num1}*${num2}=${product}<br>`)
}
mult(6,6);

let valArr=[1,2,3,4,5];
let sumVals=valArr.reduce((a,b)=>a+b);
document.write(`Sum: ${sumVals} <br>`)
let evens=valArr.filter(v=>v%2==0);
document.write(`Evens: ${evens}<br>`);
let doubles=valArr.map(v=>v*2);
document.write(`Double : ${doubles}`)



