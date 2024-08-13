const express = require("express");
const path = require("path");
const app = express();
app.get("/",(req, res)=>{
    res.send("<h1>HELLO WORLD</h1>");
});
app.get("/about",(req, res)=>{
    res.send("<h1>about page</h1>");
});
app.get("/home",(req, res)=>{
    res.send("<h1>home page</h1>");
});
app.get("/help",(req, res)=>{
    res.send("<h1>help page</h1>");
});
app.get("/contact",(req, res)=>{
    res.send("<h1>contact page</h1>");
});
app.get("/abc",(req, res)=>{
    res.sendfile(path.join(__dirname,"abc.html"));
});
app.get("/user/:name",(req,res)=>{
    const myname  =req.params.name;
    res.send(`Hello world from ${myname}`);
});
app.listen(8000,()=>{
    console.log("Server is running on port 8000");
});