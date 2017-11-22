var MongoClient = require('mongodb').MongoClient;
var url = "mongodb://localhost:27017/parkdb";

MongoClient.connect(url, function(err, db) {
  if (err) throw err;
  var myobj = [
    { locationId: '1', latitude: '37.3676464', longitude: '-121.9074857'},
    { locationId: '2', latitude: '37.3599026', longitude: '-121.9061916'}
  ];
  db.collection("locations").insertMany(myobj, function(err, res) {
    if (err) throw err;
    console.log("Number of documents inserted: " + res.insertedCount);
    db.close();
  });
});