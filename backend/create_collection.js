var MongoClient = require('mongodb').MongoClient;
var url = "mongodb://localhost:27017/parkdb";

MongoClient.connect(url, function(err, db) {
  if (err) throw err;
  db.createCollection("locations", function(err, res) {
    if (err) throw err;
    console.log("locations collection created!");
    db.close();
  });
});