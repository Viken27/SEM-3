const express = require('express');
const mongoose = require('mongoose');

const app = express()
mongoose.connect("mongodb+srv://arpitgajipara22092005:RRG3gxvnoFDBE7Zv@cluster0.czmj8.mongodb.net/")
    .then(() => console.log("Connected to MongoDB"))
    .catch(err => console.log("error" + err));
    
app.listen(3000, () => {
    console.log("server is running on port 3000");
})