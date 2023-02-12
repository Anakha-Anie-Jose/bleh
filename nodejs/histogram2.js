const fs = require('fs');

fs.readFile('data.txt', 'utf-8', (err, data) => {
  if (err) throw err;

  const words = data.split(/\b/);
  const histogram = {};

  for (const word of words) {
    if (!histogram[word]) {
      histogram[word] = 0;
    }
    histogram[word]++;
  }

  console.log(histogram);
});
