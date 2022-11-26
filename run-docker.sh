docker build --build-arg SERVICE_NAME=name-server . -t projarc/name-server:latest -f ./docker/Dockerfile

docker build --build-arg SERVICE_NAME=api-gateway . -t projarc/api-gateway:latest -f ./docker/Dockerfile

docker build --build-arg SERVICE_NAME=scta . -t projarc/scta:latest -f ./docker/Dockerfile

docker build --build-arg SERVICE_NAME=flight-plan . -t projarc/flight-plan:latest -f ./docker/Dockerfile

cd ./docker || exit

docker-compose up -d