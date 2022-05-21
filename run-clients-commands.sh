#!/bin/bash
set -e
java -jar client/target/client-0.1.jar --spring.config.location=file:///home/velesov/job4j/projects/job4j_discovery/cfg/client1.properties &
java -jar client/target/client-0.1.jar --spring.config.location=file:///home/velesov/job4j/projects/job4j_discovery/cfg/client2.properties &
exit 0