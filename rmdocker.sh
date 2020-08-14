#!/bin/sh
containerId=`docker ps -a -q -f name=$1`

if [ ${#containerId} != 0 ] ; then
    docker rm -f ${containerId}
    echo "docker rm ${containerId}"
else
    echo "not container"
fi