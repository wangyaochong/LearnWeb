/**
 * Created by wangy on 2017/4/25.
 */
define(function(require, exports, module) {
    // module.exports={
    //     moduleFunc:function () {
    //         console.log("moduleFunc","mymodule");
    //     }
    // }
    var m2=require("m2");
    console.log(m2)
    m2.sayHello();
    var exportObj={
        exportSay:function () {
            console.log("exportSay","mymodule")
        },
        sayHello:function () {
            console.log("hello","mymodule");
        }
    }
    exports.sayHello=exportObj.sayHello;
    module.exports=exportObj;

    return {
        sayHello:function () {
            console.log("hello","mymodule");
        }
    }
});