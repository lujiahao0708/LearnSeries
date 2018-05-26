#!/bin/bash
echo starting RocketMQ......

# 启动nameserver
nohup sh ./RocketMQ/bin/mqnamesrv > ./RocketMQ/log/ns.log 2>&1 &

# 睡眠1s
sleep 1

# 启动broker
nohup sh ./RocketMQ/bin/mqbroker -n 127.0.0.1:9876 -c ./RocketMQ/conf/broker.conf autoCreateTopicEnable=true  > ./RocketMQ/log/broker.log 2>&1 &

# 睡眠1s
sleep 1

echo starting RocketMQ-Console......
# 启动console
java  ${JAVA_OPTS} -jar ./RocketMQ-Console/rocketmq-console-ng-1.0.0.jar > ./RocketMQ-Console/log/console.log 2>&1 &
