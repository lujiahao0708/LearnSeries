FROM centos:7

RUN yum install -y java-1.8.0-openjdk-headless unzip gettext nmap-ncat openssl\
 && yum clean all -y \
 && yum install -y wget

RUN adduser elasticsearch

USER elasticsearch

ARG version

# Rocketmq version
ENV EK_VERSION ${version}

# Rocketmq home
ENV EK_HOME  /home/elasticsearch

WORKDIR  ${EK_HOME}

ENV ES_TMPDIR=/home/elasticsearch/elasticsearch.tmp

RUN wget -q -O - https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-${EK_VERSION}.tar.gz \
 |  tar -zx \
 && mv elasticsearch-${EK_VERSION} elasticsearch \
 && mkdir -p ${ES_TMPDIR} \
 && wget -q -O - https://artifacts.elastic.co/downloads/kibana/kibana-${EK_VERSION}-linux-x86_64.tar.gz \
 |  tar -zx \
 && mv kibana-${EK_VERSION}-linux-x86_64 kibana

CMD ./elasticsearch/bin/elasticsearch -E http.host=0.0.0.0 --quiet & ./kibana/bin/kibana --host 0.0.0.0 -Q

EXPOSE 9200 5601