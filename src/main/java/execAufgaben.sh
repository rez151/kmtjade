#!/bin/sh
java -classpath ".:src:jade/lib/jade.jar" jade.Boot -gui
#-agents timer:jade.src.examples.agents.TimerAgent
