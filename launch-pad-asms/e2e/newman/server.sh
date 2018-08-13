#!/usr/bin/env bash

DIR="$(cd "$(dirname "$0")" && pwd)"
cd $(echo $DIR)
java -jar ../../server/target/launchpad.jar
