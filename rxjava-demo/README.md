# Reactive Programming by Venkat Subramaniam Note

## stream vs observable
Stream do not handle exception
It is difficult to know the end of stream
Stream could not have multiple subscribers

observable handle exception with onError, and have data channel & error channel
observable could send a end signal
observable could accept multiple subscribers

observable is stream ++

## Designing reactive systems:
partition based on user location/query
sharding and replication
failure as first class citizen
not on all or noting proposition
 network failures
 database failures
 provide redundancies across geographical locations
 load related failures
Use Circuit breakers
Improved performance using parallelization
CAP theorem