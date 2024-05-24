#!/bin/sh

docker rmi -f daergaothdev/svnhook-server:latest
docker rmi -f svnhook-server:latest
docker build -t svnhook-server .
docker tag unity-server:latest daergaothdev/svnhook-server:latest