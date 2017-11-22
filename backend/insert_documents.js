var MongoClient = require('mongodb').MongoClient;
var url = "mongodb://localhost:27017/parkdb";

/*
delete all previous documents and insert new documents*/
MongoClient.connect(url, function(err, db) {
  if (err) throw err;
    db.collection("locations").remove({}, function(err, numberRemoved) {
      if (err) throw err;
      console.log("Number of removed documents" + numberRemoved);
    });

  var myobj = [
    { locationId: '1', latitude: '37.3676464', longitude: '-121.9074857'},
    { locationId: '2', latitude: '37.3599026', longitude: '-121.9061916'},
    { locationId: '3', latitude: '37.3512048', longitude: '-121.8977011'},
    { locationId: '4', latitude: '37.3428377', longitude: '-121.9152309'}
  ];
  db.collection("locations").insertMany(myobj, function(err, res) {
    if (err) throw err;
    console.log("Number of documents inserted: " + res.insertedCount);
    db.close();
  });
});