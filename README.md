#Storage
## Cassandra
Cassandra version: 3.11

single cassandra node in docker: 

    docker run -d -p 9042:9042 cassandra:3.11 

#Docker
## Base image 
docker pull openjdk:11.0 
## Maven dockerfile plugin
The officail site: https://github.com/spotify/dockerfile-maven

#Kafka
## Base Image
docker pull confluent/kafka