Instalation of the mongodb with docker: 
https://docs.mongodb.com/manual/tutorial/install-mongodb-enterprise-with-docker/
To connect to the mongo shell execute that command: docker exec -it mongoContainer mongo

TODO document all the needed commands.

Para el tema de gestión de tareas uso trello en vez de docker por no tener la limitacion de una licencia temporal
https://hub.docker.com/r/rubygem/github-trello/

`docker pull rubygem/github-trello`

`docker run -v $(pwd):/work -ti docker-gems/github-trello`

As many of the configurations of the data base are passed as a configuration parameter, the way to execute the app is as
 the following example:

`mvn spring-boot:run -DDATABASE_USER=myuser -DDATABASE_PASSWORD=mypassword -DDATABASE_NAME=resumedb`


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
