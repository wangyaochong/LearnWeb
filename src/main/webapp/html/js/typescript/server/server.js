"use strict";
exports.__esModule = true;
var express = require("express");
var app = express();
app.route("/api/course").get(function (req, res) {
    res.status(200).json({ "message": "hello world" });
});
app.listen(8090, function () {
    console.log('server is running...');
});
//# sourceMappingURL=server.js.map