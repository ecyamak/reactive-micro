#!/bin/bash
if [ "$1" = "up" ]; then
  cd auth-service
  docker compose up -d
  cd ../first-service
  docker compose up -d
  cd ../second-service
  docker compose up -d
  cd ../discovery-service
  docker compose up -d
elif [ "$1" = "down" ]; then
  cd auth-service
  docker compose down -v
  cd ../first-service
  docker compose down -v
  cd ../second-service
  docker compose down -v
  cd ../discovery-service
  docker compose down -v
else
  echo "invalid command"
fi