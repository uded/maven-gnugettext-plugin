#!/bin/bash
xgettext -ktrc -ktr -kmarktr -ktrn:1,2 -o keys.pot $(find ./src/ -name "*.java")