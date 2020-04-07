Installation of the mongodb with docker: 
https://docs.mongodb.com/manual/tutorial/install-mongodb-enterprise-with-docker/
To connect to the mongo shell execute that command: docker exec -it mongoContainer mongo

TODO document all the needed commands.

Para el tema de gestión de tareas uso trello en vez de docker por no tener la limitacion de una licencia temporal
https://hub.docker.com/r/rubygem/github-trello/

`docker pull rubygem/github-trello`

`docker run -v $(pwd):/work -ti docker-gems/github-trello`

As many of the configurations of the data base are passed as a configuration parameter, the way to execute the app is as
 the following example:

`mvn spring-boot:run -DDATABASE_USER=myuser -DDATABASE_PASSWORD=mypassword -DDATABASE_NAME=resumedb -DcorsIp=http://XXX.XXX.XXX.XXX:3000`


How to install mongodb 3 in a raspberry environment:

`https://hub.docker.com/r/andresvidal/rpi3-mongodb3/`

How to configure the users of the data base:

`db.createUser(
{ user: "myuser", pwd: "mypassword", roles: [ { role: "dbOwner", db: "resumedb" } ] })`

`db.grantRolesToUser(
    "myuser",
    [
      { role: "read", db: "resumedb" }
    ]
)`

In case that the mongodb docker image is always restarting execute the following command:
`sudo rm /data/db/mongod.lock`

Example of initial insertion for education:

`db.education.insert({ "language":"EN", "startDate":"1997", "endDate":"2000", "title":"Bachelor Technology", "subTitle":"Analist programmer", "description":"Three years of a technical bachelor" })`

`db.education.insert({ "language":"EN", "startDate":"2015", "title":"Independient course. Software develop.", "subTitle":"Coursera Inc.", "description":"An introduction to interactive programming in python (part 1)" })`

`db.education.insert({ "language":"EN", "startDate":"2013", "title":"Certification Databases", "subTitle":"Mongo university", "description":"m101j - mongodb certification." })`

In prod environment we have a script to configure all the parameters `applyConfig.sh` the content of the file is as follows:
`#!/bin/sh
 export DATABASE_NAME=resumedb
 export DATABASE_USER="myuser"
 export DATABASE_PASSWORD="mypassword"
 export CORS_IP=http://SOME_IP:SOME_PORT`