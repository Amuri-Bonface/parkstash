var express = require('express')
var app = express()
var MongoClient = require('mongodb').MongoClient;
var url = "mongodb://localhost:27017/parkdb";

/*
query all documents and display as json file
To use this NodeJS server, you have to install MongoDB and launch it first.
https://docs.mongodb.com/manual/tutorial/install-mongodb-on-windows/

eg. start and connect using command line
C:\Program Files\MongoDB\Server\3.4\bin>mongod --dbpath "C:\YOUR-PATH\parkstash\backend\data
C:\Program Files\MongoDB\Server\3.4\bin>mongo localhost:27017
*/
app.get('/locations', function(req, res) {
    MongoClient.connect(url, function(err, db) {
      if (err) throw err;
      var query = {};
      db.collection("locations").find(query).toArray(function(err, result) {
        if (err) throw err;
        res.json(result)
        db.close();
      });
    });
})

app.listen(3000)