#!/bin/sh
containerId=`docker ps -a -q -f name=$1`

if [ -n ${containerId} ] ; then
    docker rm -f ${containerId}
    echo "docker rm ${containerId}"
else
    echo "not container"
fi