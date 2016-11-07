#/usr/bin/env bash
mkdir -p ./bin
javac -d ./bin -Xlint:unchecked -classpath .:classes:lib/'*' ./src/edu/ccsu/cs417/cs417group1/robot/*.java ./src/edu/ccsu/cs417/cs417group1/camera/*.java
