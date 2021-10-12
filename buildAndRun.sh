#!/bin/sh
mvn clean package && docker build -t com.zsalcedo/Pokedex .
docker rm -f Pokedex || true && docker run -d -p 9080:9080 -p 9443:9443 --name Pokedex com.zsalcedo/Pokedex