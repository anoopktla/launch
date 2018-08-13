#!/usr/bin/env bash

DIR="$(cd "$(dirname "$0")" && pwd)"
cd $(echo $DIR)
npm install
npm run smoke
