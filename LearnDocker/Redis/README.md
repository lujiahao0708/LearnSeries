# Redis 相关的部署文件
- redis.conf：Redis 默认配置文件(http://download.redis.io/redis-stable/redis.conf)


## 1.redis-single
使用自定义的配置文件,会发现无法使用外部工具连接

Docker启动Redis容器，步骤很简单，和启动mysql容器是一样的：Docker启动mysql。不过有个点需要注意，这里提醒一下：

当Redis启动后发现连接不上，是因为Redis默认是不支持远程连接的，需要修改配置文件。

先查看 redis 容器的ip 地址:
docker inspect local-redis
找到 NetworkSettings  Networks  IPAddress
"IPAddress": "172.17.0.3",

打开redis的配置文件
bind 127.0.0.1
改为 
bind 127.0.0.1 172.17.0.3

127.0.0.1 : 本机连接使用  redis-cli
172.17.0.3 : 外部机器连接使用

重新使用客户端连接即可

> 这里需要注意下,网上有些教程说可以改成 0.0.0.0 不推荐这么做
> https://juejin.im/post/5d258b6ae51d454f73356dcf   0.0.0.0有一定的安全隐患

