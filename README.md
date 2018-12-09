#Storage
## Cassandra
Cassandra version: 3.11

single cassandra node in docker: 
docker run -d cassandra:3.11 -p 7000:7000

#Docker
## Base image 
docker pull openjdk:11.0 
## Maven dockerfile plugin
The officail site: https://github.com/spotify/dockerfile-maven