type Name = {
    firstName?: string,
    lastName: string
}
type Address = {
    streetName: string
}
type Person = {
    name: Name,
    address?: Address
}
let person: Person = {
    name: {
        firstName: 'kobe',
        lastName: 'bryant'
    }
}
// person.age=18;
type MessageCreator=(name:string)=>string;


function createHelloMessage(name:string):string{
    // return 1;
    return 'hello,'+name;
}
const creator:MessageCreator=createHelloMessage;

// debugger;
console.log(createHelloMessage('wangyaochong'));
console.log(creator('wangyaochong'));

enum PlayerPosition{
    Guard,
    Forward,
    Center

}
interface  Player{
    name:string,
    position:PlayerPosition
}
let kobe:Player|null|undefined={
    name:'kobe',
    position:PlayerPosition.Guard
}

// kobe=null;
// kobe=undefined;

