#!/bin/bash
sh ./RocketMQ/bin/mqshutdown 
sh ./RocketMQ/bin/mqshutdown broker 
sh ./RocketMQ/bin/mqshutdown namesrv


PID=$(ps -ef | grep rocketmq-console-ng-1.0.0.jar | grep -v grep | awk '{ print $2 }')
if [ -z "$PID" ]
then
    echo Application is already stopped
else
    echo kill $PID
    kill $PID
fi
