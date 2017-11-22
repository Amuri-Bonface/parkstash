var express = require('express')
var app = express()
var MongoClient = require('mongodb').MongoClient;
var url = "mongodb://localhost:27017/parkdb";

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