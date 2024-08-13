const express = require('express');

const app = express();

const middlewarefunction = (req,res,next) => {
    console.log("Middleware function called!");
    next();
};
const paisavalufunction = (req, res, next) => {
    console.log("second function called!");
    next();
};
app.get('/hello', middlewarefunction,paisavalufunction,(req, res, next) => {
    console.log("actual function called!");
    res.send("<h1>Home page is here</h1>");
});

app.listen(8000, () => {
console.log("Server is running on port 8000!");
});