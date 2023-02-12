// const fs = require('fs');
// fs.readFile('data.txt', 'utf-8', (err, data) => {
//     if (err) throw err;
  
    
  
//     console.log(data);
//   });
  
import {readFile} from 'node:fs';
readFile('data.txt',(err, data) => {
    if (err) throw err;
  
    
  
    console.log(data);
  });