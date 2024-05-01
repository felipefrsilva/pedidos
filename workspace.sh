#!/bin/bash
####################################################################
##### show usage
####################################################################
function help() {
  echo " Workspace functions"
  echo -e "usage:  up [service-name] | down | recreate [service-name] | status | log [service-name] | terminal [service-name] | start [service-name] | stop [service-name] | prune | help"
  echo "---------------------------------------------------------------------------------------------------------------"
  echo "# Up: ./workspace.sh up"
  echo " args: service-name[optional] = defined in "$dockerComposeCmd" file "
  echo " if service-name was not informed then the script will build de jar (mvn clean package -DskipTests) and after will create the containers => "$dockerComposeCmd" up -d --build"
  echo " if service-name was informed then the script will build de jar (mvn clean package -DskipTests) and after will create only the specific container => "$dockerComposeCmd" up -d --build [service-name]"
  echo "---------------------------------------------------------------------------------------------------------------"
  echo "# Down: ./workspace.sh down"
  echo " will destroy all containers"
  echo "---------------------------------------------------------------------------------------------------------------"
  echo "# Recreate: ./workspace.sh recreate"
  echo " args: service-name[optional] = defined in "$dockerComposeCmd" file "
  echo " if service-name was not informed then the script will execute down and up functions"
  echo " if service-name was informed then the script recreate the specific contianer"
  echo "---------------------------------------------------------------------------------------------------------------"
  echo "# Status: ./workspace.sh status"
  echo " will execute "$dockerComposeCmd" status"
  echo "---------------------------------------------------------------------------------------------------------------"
  echo "# Log: ./workspace.sh logs [service-name]"
  echo " args: service-name[required] = defined in "$dockerComposeCmd" file "
  echo " will execute "$dockerComposeCmd" logs -f [service-name]"
  echo "---------------------------------------------------------------------------------------------------------------"
  echo "# Terminal: ./workspace.sh terminal [service-name]"
  echo " args: service-name[required] = defined in "$dockerComposeCmd" file "
  echo " will open interective shell for the service-name"
  echo "---------------------------------------------------------------------------------------------------------------"
  echo "# Start: ./workspace.sh start [service-name]"
  echo " args: service-name[optional] = defined in "$dockerComposeCmd" file "
  echo " will start all services if service-name was not informed"
  echo " but if it's present than only that specific service will be strated"
  echo "---------------------------------------------------------------------------------------------------------------"
  echo "# Stop: ./workspace.sh stop [service-name]"
  echo " args: service-name[optional] = defined in "$dockerComposeCmd" file "
  echo " will stop all services if service-name was not informed"
  echo " but if it's present than only that specific service will be stoped"
  echo "---------------------------------------------------------------------------------------------------------------"
  echo "# Prune: ./workspace.sh prune"
  echo " before it will execute the down function and then will execute docker system prune --all -f --volumes"
  echo "---------------------------------------------------------------------------------------------------------------"
  echo
}

# Check Docker version
docker_version=$(docker -v | awk '{print $3}' | cut -d ',' -f1)

# Define Docker Compose command based on Docker version
#if dpkg --compare-versions "$docker_version" "ge" "20.10.15"; then
#    dockerComposeCmd="docker compose"
#else
#    dockerComposeCmd="docker-compose"
#fi
dockerComposeCmd="docker-compose"

####################################################################
##### show status
####################################################################

function status() {
  "$dockerComposeCmd" -f "$dockerComposeFile" ps
}

####################################################################
##### up containers
####################################################################

function up() {
  if [ "$service" == "" ]; then
    "$dockerComposeCmd" -f "$dockerComposeFile" up -d --build
  else
    "$dockerComposeCmd" -f "$dockerComposeFile" up -d --build  "$service"
  fi
}

####################################################################
##### down containers
####################################################################

function down() {
  "$dockerComposeCmd" -f "$dockerComposeFile" down --remove-orphans --rmi local
}

####################################################################
##### recreate containers
####################################################################

function recreate() {
    if [ "$service" == "" ]; then
       down && up
    else
       validateIfServiceExists
       stop
       docker rm $(docker ps -a -f "name=$service" -q)
       sleep 1
       up
    fi
}

####################################################################
##### show logs
####################################################################

function log() {
  validateIfServiceWasInformed
  validateIfServiceExists
  "$dockerComposeCmd" -f "$dockerComposeFile" logs -f "$service"
}

####################################################################
##### open container terminal
####################################################################

function terminal() {
  validateIfServiceWasInformed
  validateIfServiceExists
  "$dockerComposeCmd" -f "$dockerComposeFile" exec -ti "$service" /bin/sh
}

####################################################################
##### start container
####################################################################

function start() {
  if [ "$service" == "" ]; then
    "$dockerComposeCmd" -f "$dockerComposeFile" start
  else
    "$dockerComposeCmd" -f "$dockerComposeFile" start "$service"
  fi
}

####################################################################
##### stop container
####################################################################

function stop() {
  if [ "$service" == "" ]; then
    "$dockerComposeCmd" -f "$dockerComposeFile" stop
  else
    "$dockerComposeCmd" -f "$dockerComposeFile" stop "$service"
  fi
}

####################################################################
##### prune all docker artifacts
####################################################################

function prune() {
  down &&
  docker system prune --all -f --volumes
}

####################################################################
##### util functions
####################################################################

function printMessage() {
  echo -e "[$(date "$dateFormat")] $1"
}

function validateIfServiceWasInformed() {
  if [ -z "$service" ]; then
    printMessage "Service name was not informed"
    exit
  fi
}

function validateIfServiceExists() {
  serviceSearched="$("$dockerComposeCmd" -f "$dockerComposeFile" ps --format json | jq '.[] | select(.Name=='\"$service\"')')"

  if [ -z "$serviceSearched" ]; then
    printMessage "Service [$service] does not exits or its not running"
    exit
  fi
}

####################################################################
##### Prepare arguments
####################################################################

dockerComposeFile="docker/"$dockerComposeCmd".yml"
dateFormat="+%d-%m-%Y %H:%M:%S"
shouldBuildApp="yes"
service=""
job="$1"

while [ "$1" != "" ]; do
 case "$1" in
       -s | --service-name)
             shift
             service="$1"
             ;;
       -nb | --no-build)
                  shift
                  shouldBuildApp="no"
                  ;;
 esac
 shift
done

####################################################################
##### Main
####################################################################
case "$job" in
help)
  help
  ;;
up)
  up
  ;;
down)
  down
  ;;
recreate)
  recreate
  ;;
status)
  status
  ;;
log)
  log
  ;;
terminal)
  terminal
  ;;
start)
  start
  ;;
stop)
  stop
  ;;
prune)
  prune
  ;;
*)
  printMessage "ERROR: command [$job] not found."
  help
  exit 1
  ;;
esac