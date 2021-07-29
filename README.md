# DockerSpringRedis

Spring boot, Docker compose, Redis example

## Build the jar

`mvn clean package`

## Building the image

Define a docker image with named `redis-service` and a tag `v1` defined by using -t option:  
`docker build -t redis-server:v1 .`

## Run the image

`docker run -d -v ~/docker/redis:/redis-service/logs -p 8080:8080 redis-server:v1`

- d - Run the container in detached mode, simply running the container int the background.
- v - Mount a volume. (host-src: container:src)  We have mounted the directory ~/docker/redis in the host to the
  directory /redis-service/logs in the container, so we can persist and view live logs without going inside the
  container.
- p - Map the port on host to port the app listening in the container

## view running containers

`docker ps`

## Bash

`docker exec -it <container-id> bash`

## Stop

`docker stop <container-id>`

## Running the containers

Run the command from the terminal inside the project directory:   
`docker-compose up --build`

## View running containers

`docker-compose ps`
you should see:

- redis
- spring-redis

## Stopping the containers

`docker-compose stop`

## cli

`docker-compose exec redis redis-cli`

## Redis Data Endpoints

Create

```
curl -X POST --location "http://localhost:8080/api/create" \
    -H "Content-Type: application/json" \
    -d "{
          \"id\": 1,
          \"department\": \"dev\",
          \"name\": \"phil\",
          \"email\": \"phil@4loop.co.uk\"
        }"
```

List

```
curl -X GET --location "http://localhost:8080/api/employees" \
    -H "Accept: application/json"
```

etc...

## Redis Message Queue Endpoints

Publish

```
curl -X POST --location "http://localhost:8080/message/send" \
    -H "Content-Type: application/text" \
    -d "This is a message"
```

Subcribed

```
curl -X GET --location "http://localhost:8080/message/get" \
    -H "Accept: application/json"
```
