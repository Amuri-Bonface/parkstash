var MongoClient = require('mongodb').MongoClient;
var url = "mongodb://localhost:27017/parkdb";

MongoClient.connect(url, function(err, db) {
  if (err) throw err;
  var myobj = [
    { locationId: '1', address: 'Highway 71'},
    { locationId: '2', address: 'Lowstreet 4'}
  ];
  db.collection("locations").insertMany(myobj, function(err, res) {
    if (err) throw err;
    console.log("Number of documents inserted: " + res.insertedCount);
    db.close();
  });
});