安装jdk
https://www.linuxidc.com/Linux/2016-09/134941.htm
yum search java|grep jdk
yum -y install java-1.8.0-openjdk.x86_64

yum -y install wget

yum -y install unzip

下载rocketmq
wget https://mirrors.tuna.tsinghua.edu.cn/apache/rocketmq/4.2.0/rocketmq-all-4.2.0-bin-release.zip


nohup sh mqnamesrv > /var/log/nameserver.log 2>&1 &


nohup sh mqbroker -n "127.0.0.1:9876" autoCreateTopicEnable=true > /var/log/broker.log 2>&1 &


sh mqshutdown 
sh mqshutdown broker 
sh mqshutdown namesrv


# 在bin目录下面执行，将服务器地址引入到环境变量中
$ export NAMESRV_ADDR=127.0.0.1:9876
# 通过java代码实现的案例生产者生产消息
$ sh tools.sh org.apache.rocketmq.example.quickstart.Producer
# 通过java代码实现案例消费者消费消息
$ sh tools.sh org.apache.rocketmq.example.quickstart.Consumer




namesrvAddr=192.168.0.18:9876
brokerIP1=192.168.0.18
brokerName=S018
brokerClusterName=DefaultCluster
brokerId=0
autoCreateTopicEnable=true
autoCreateSubscriptionGroup=true
rejectTransactionMessage=false
fetchNamesrvAddrByAddressServer=false
storePathRootDir=/root/store
storePathCommitLog=/root/store/commitlog
flushIntervalCommitLog=500
commitIntervalCommitLog=200
flushCommitLogTimed=false
deleteWhen=04
fileReservedTime=72
maxTransferBytesOnMessageInMemory=262144
maxTransferCountOnMessageInMemory=32
maxTransferBytesOnMessageInDisk=65536
maxTransferCountOnMessageInDisk=8
accessMessageInMemoryMaxRatio=40
messageIndexEnable=true
messageIndexSafe=false
haMasterAddress=
brokerRole=ASYNC_MASTER
flushDiskType=ASYNC_FLUSH
cleanFileForciblyEnable=true
transientStorePoolEnable=false