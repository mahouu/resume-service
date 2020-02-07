Instalation of the mongodb with docker: 
https://docs.mongodb.com/manual/tutorial/install-mongodb-enterprise-with-docker/
To connect to the mongo shell execute that command: docker exec -it mongoContainer mongo

TODO document all the needed commands.

Para el tema de gestión de tareas uso trello en vez de docker por no tener la limitacion de una licencia temporal
https://hub.docker.com/r/rubygem/github-trello/

docker pull rubygem/github-trello
docker run -v $(pwd):/work -ti docker-gems/github-trello
