# RocketMQ
RocketMQ 相关 Docker 部署配置文件.

> 注意修改 `conf` 文件中的 `brokerIP1=本机IP地址`,否则无法成功!!!

## RocketMQ-single
RocketMQ 单节点示例,包含`nameserver` `broker` 和 `console`。
## RocketMQ-cluster-2m-2s-sync
RocketMQ 单节点示例,包含`nameserver`集群(2个结点),`broker`集群(2主2从) 和 `console`。
## RocketMQ-2-cluster
两个单节点集群,控制台端口号分别为 `http://localhost:8080` 和 `http://localhost:8081`

---

> 本仓库中 `docker-compose.yml` 修改自官方仓库:https://github.com/apache/rocketmq-docker
> `console` 控制台来自:https://github.com/apache/rocketmq-externals/tree/master/rocketmq-console
