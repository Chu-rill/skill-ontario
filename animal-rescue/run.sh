#!/bin/bash
mvn clean package
docker build -t animal-rescue-jar-with-dependencies .
docker run -it animal-rescue-jar-with-dependencies