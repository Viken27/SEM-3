const cp = require("child_process");
cp.exec("dir",(err,stdout,stdin) => {
    console.log(stdout);
});