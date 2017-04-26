/**
 * Created by wangy on 2017/4/25.
 */
/**
 * Created by wangy on 2017/4/25.
 */
define(function(require, exports, module) {
    // module.exports={
    //     moduleFunc:function () {
    //         console.log("moduleFunc","mymodule");
    //     }
    // }
    var exportObj={
        exportSay:function () {
            console.log("exportSay","mymodule")
        },
        sayHello:function () {
            console.log("hello m2","mymodule");
        }
    }

    exports.sayHello=exportObj.sayHello;
    module.exports=exportObj;
    return {
        sayHello:function () {
            console.log("hello m2","mymodule");
        }
    }
});