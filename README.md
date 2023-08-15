# Employee-Management-in-Reactive-Request-Programming-
A Spring WebFlux application developed in Employee Management System.

## Motivation:-
In my past projects, I have been using traditional request programming. What is this means the thread will wait until it has been processed without taking another request. So by this process lot of resources will be wasted. So to optimize it this project uses a reactive programming request model in which the thread won't wait for any request to be completed by db it will simultaneously hold another request as well.< br/>

## Architecture:-
![This is an image](https://github.com/srinathsai/Employee-Management-in-Reactive-Request-Programming-/blob/main/Springwebflux%20architecture.jpg) 

## Key differences:-
Here in this architecture every layer returns either Mono or Flux type. And also traditional dbs won't work here so we use MongoDB pulled from the docker hub.

## Tools Required:-
  - IntelliJIdea
  - Docker Desktop
  - PostMan Client
  - Mongodb image from Dockers.
    
## Steps of Execution:-
  1) First from Dockerhub pull MongoDB.
  2) Next in the application.properties file from my folder change the data source link to the name of the image that you have saved which contains MongoDB.
  3) 
