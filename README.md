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
    docker build -t nicolas2lee/kafka:latest -t nicolas2lee/kafka:2.12-2.1.0 .

## Create zookeeper nodes
    kubectl create -f kubernetes/kafka-zookeeper-cluster.yml
    
## Create kafka server nodes
    kubectl create -f kubernetes/kafka-server-cluster.yml
    
Kafka configuration:
https://github.com/kubernetes/contrib/tree/master/statefulsets/kafka