# SCTA
Microservices created for Software Project and Architecture class on Software Engineering course.

## Running the project
Build each service with `mvn package` <br>
Build the image for each service <br>
```bash
docker build --build-arg SERVICE_NAME=${SERVICE_NAME} . -t projarc/${IMAGE_NAME}:latest -f ./docker/Dockerfile
```

And then finally run the docker-compose file on `./docker`

Or... 

Just run the `run-docker.sh` file on the root of the project