@echo off
call mvn clean package
call docker build -t com.zsalcedo/Pokedex .
call docker rm -f Pokedex
call docker run -d -p 9080:9080 -p 9443:9443 --name Pokedex com.zsalcedo/Pokedex