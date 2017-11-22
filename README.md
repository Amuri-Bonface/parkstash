# Parkstash Introduction
## Technologies
NodeJS + Express + MongoDB + Android

## Pre_Installation
* Install NodeJS, Express, MongoDB, Android Studio

## Installation
* Clone project to your Android Studio. 
* Run `C:\Program Files\MongoDB\Server\3.4\bin>mongod --dbpath "C:\YOUR-PARTH\parkstash\backend\data` to start MongoDB
* Run `C:\Program Files\MongoDB\Server\3.4\bin>mongo localhost:27017` to connect MongoDB
* Run `C:\YOUR-PARTH\parkstash\backend>node index.js` to start NodeJS server
* Open up your browser, and visit `http://localhost:3000/locations` to check json data
* In Android Studio, put your Google-Map-API key in key.xml file
* In Android Studio, In `MainActivity.java`, replace your device IP in `LOCAL_URL`[Help link](https://stackoverflow.com/questions/4779963/how-can-i-access-my-localhost-from-my-android-device)
* Run parkstash in Android Studio

## Features
* ParkStash will fetch location data from local server and display location markers on google map 
* Backend: Node.js server with MongoDB
* Android app with Google map

<img src="https://user-images.githubusercontent.com/24383706/33145047-edbbef6c-cf73-11e7-85c9-daff59919204.png" width="320"> <img src="https://user-images.githubusercontent.com/24383706/33145048-eeab07f0-cf73-11e7-97b4-22c335ffece8.png" width="320"> 

### Reference:
* [MongoDB](https://docs.mongodb.com/manual/tutorial/install-mongodb-on-windows/)
* [Node.js MongoDB](https://www.w3schools.com/nodejs/nodejs_mongodb.asp)
* [Tutorial](https://closebrace.com/tutorials/2017-03-02/the-dead-simple-step-by-step-guide-for-front-end-developers-to-getting-up-and-running-with-nodejs-express-and-mongodb)
