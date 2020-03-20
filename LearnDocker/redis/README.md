# Redis 相关的部署文件
- redis.conf：Redis 默认配置文件


## 1.redis-single
使用自定义的配置文件,会发现无法使用外部工具连接

Docker启动Redis容器，步骤很简单，和启动mysql容器是一样的：Docker启动mysql。不过有个点需要注意，这里提醒一下：

当Redis启动后发现连接不上，是因为Redis默认是不支持远程连接的，需要修改配置文件。

执行如下命令，会发现只能本地连接，127.0.0.1连接

root@iZuf6axmuekh1n14dwcufmZ:~# ps -ef |grep redis
root      1674   361  0 15:31 pts/1    00:00:00 grep --color=auto redis
root     14954     1  0  2017 ?        00:24:08 ./redis-server 127.0.0.1:6379
打开redis的配置文件
bind 127.0.0.1
改为 
bind 0.0.0.0
或者注释掉即可

再次查看：

root@iZuf6axmuekh1n14dwcufmZ:~# ps -ef |grep redis
root      1674   361  0 15:31 pts/1    00:00:00 grep --color=auto redis
root     14954     1  0  2017 ?        00:24:08 ./redis-server 0.0.0.0:6379
发现地址变为：0.0.0.0。

