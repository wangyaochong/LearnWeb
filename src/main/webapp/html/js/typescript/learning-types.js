var person = {
    name: {
        firstName: 'kobe',
        lastName: 'bryant'
    }
};
function createHelloMessage(name) {
    // return 1;
    return 'hello,' + name;
}
var creator = createHelloMessage;
// debugger;
console.log(createHelloMessage('wangyaochong'));
console.log(creator('wangyaochong'));
var PlayerPosition;
(function (PlayerPosition) {
    PlayerPosition[PlayerPosition["Guard"] = 0] = "Guard";
    PlayerPosition[PlayerPosition["Forward"] = 1] = "Forward";
    PlayerPosition[PlayerPosition["Center"] = 2] = "Center";
})(PlayerPosition || (PlayerPosition = {}));
var kobe = {
    name: 'kobe',
    position: PlayerPosition.Guard
};
// kobe=null;
// kobe=undefined;
//# sourceMappingURL=learning-types.js.map