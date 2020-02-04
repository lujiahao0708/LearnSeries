在用户目录下创建 dockerData文件夹，然后将es和logstash的文件夹拷贝到这个目录下

## ES配置文件
```yaml
elasticsearch.yml
http.host: 0.0.0.0

# Uncomment the following lines for a production cluster deployment
#transport.host: 0.0.0.0
#discovery.zen.minimum_master_nodes: 1
```

log4j2.properties
```
status = error

appender.console.type = Console
appender.console.name = console
appender.console.layout.type = PatternLayout
appender.console.layout.pattern = [%d{ISO8601}][%-5p][%-25c{1.}] %marker%m%n

rootLogger.level = info
rootLogger.appenderRef.console.ref = console
```

## 配置logstash
logstash.conf
```
input {
    tcp {
        port => 4560
        codec => json_lines
    }
}
output{
  elasticsearch { 
   # es地址
   hosts => ["elasticsearch:9200"]
   # 索引名称 
   index => "applog"
   }
  stdout { codec => rubydebug }
}
```

## docker-compose.yml
```
version: '3'
services:
  elasticsearch:
    container_name: elasticsearch
    image: elasticsearch:5.6.11
    environment:
      - "ES_JAVA_OPTS=-Xms128m -Xmx256m"
    volumes:
      - /Users/lujiahao/dockerData/elasticsearch/data:/usr/share/elasticsearch/data
      - /Users/lujiahao/dockerData/elasticsearch/config:/usr/share/elasticsearch/config
    restart: always
    ports:
      - "9200:9200"
      - "9300:9300"
  kibana:
    container_name: kibana
    image: kibana:5.6.11
    environment:
      - "ELASTICSEARCH_URL=http://elasticsearch:9200"
    depends_on:
      - elasticsearch
    links:
      - elasticsearch
    restart: always
    ports:
      - "5601:5601"
  logstash:
    container_name: logstash
    image: logstash:5.6.15
    # logstash 启动时使用的配置文件
    command: logstash -f /etc/logstash/conf.d/logstash.conf
    volumes:
      # logstash 配文件位置
      - /Users/lujiahao/dockerData/logstash/conf.d/logstash.conf:/etc/logstash/conf.d/logstash.conf
    restart: always
    depends_on:
      - elasticsearch
    links:
      - elasticsearch
    ports:
      - "4560:4560"
```
