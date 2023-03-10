#!/bin/bash
if [ "$1" = "up" ]; then
  cd auth-service
  docker compose up -d
  cd ../first-service
  docker compose up -d
  cd ../second-service
  docker compose up -d
elif [ "$1" = "down" ]; then
  cd auth-service
  docker compose down
  cd ../first-service
  docker compose down
  cd ../second-service
  docker compose down
  docker volume prune -f
else
  echo "invalid command"
fi