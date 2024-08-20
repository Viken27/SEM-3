const feculty = require('./faculty');
const mongoose = require('mongoose');
const express = require('express');
const bodyParser = require('body-parser');
mongoose.connect(connectionString).then(()=>{
    const app = express();
   app.use(bodyParser.urlencoded({extends: false}));
   console.log("Connection Established");
   app.get('/Home',async (req, res)=>{
    const result = await faculty.find();
    res.json(result);
   });
   app.get('/Home/:id',async (req, res)=>{
    const result = await faculty.findOne(req.params.id);
    res.json(result);
   });
   app.listen(7000,()=>{
    console.log("Server is running on port 7000");
   });
});