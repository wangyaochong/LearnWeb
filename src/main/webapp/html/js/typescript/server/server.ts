import  * as ORM from "sequelize";
import  * as express from "express";
import  {Application} from "express";
const app:Application=express();
app.route("/api/course").get((req,res)=>{
    res.status(200).json({"message":"hello world"});
})
app.listen(8090,()=>{
    console.log('server is running...');
})
