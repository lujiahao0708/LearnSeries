docker run -itd -v $PWD/conf/single-node.conf:/usr/local/etc/redis/redis.conf \
-p 6379:6379 --name local-redis redis redis-server /usr/local/etc/redis/redis.conf
