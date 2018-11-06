#!/bin/bash

host_ip=`/sbin/ifconfig -a|grep inet|grep -v 127.0.0.1|grep -v inet6 |grep broadcast |grep -v 172 | awk '{print $2}' | tr -d "addr:"`
echo HostIP: $host_ip

# Build base image
docker build -t lujiahao/elasticsearch-kibana:5.5.0 --build-arg version=5.5.0 .

# Run namesrv and broker

docker run -d -p 9200:9200 -p 5601:5601 --name elasticsearch-kibana_5.5.0 lujiahao/elasticsearch-kibana:5.5.0
