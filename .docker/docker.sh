#!/bin/bash
if [ "$1" = "mongo" ]; then
  if [ "$2" = "up" ]; then
    docker compose -f docker-compose-mongo.yml up -d
  elif [ "$2" = "down" ]; then
    docker compose -f docker-compose-mongo.yml down -v
  else
    echo "invalid command"
  fi
elif [ "$1" = "kafka" ]; then
  if [ "$2" = "up" ]; then
    docker compose -f docker-compose-kafka.yml up -d
  elif [ "$2" = "down" ]; then
    docker compose -f docker-compose-kafka.yml down -v
  else
    echo "invalid command"
  fi
elif [ "$1" = "config" ]; then
  if [ "$2" = "up" ]; then
    cd ../config-service
    docker build -t config-service .
    docker run -d -p 8888:8888 --name config-service config-service
  fi
else
  echo "invalid command"
fi