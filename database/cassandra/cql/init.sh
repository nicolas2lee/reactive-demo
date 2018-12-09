CREATE KEYSPACE reactive_demo_dev
WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};