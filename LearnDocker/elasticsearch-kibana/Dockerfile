FROM openjdk:jre-alpine

LABEL maintainer "nshou <nshou@coronocoya.net> https://bitbucket.org/nshou/elasticsearch-kibana"

ARG ek_version=5.5.0

RUN apk add --quiet --no-progress --no-cache nodejs wget \
 && adduser -D elasticsearch

USER elasticsearch

WORKDIR /home/elasticsearch

ENV ES_TMPDIR=/home/elasticsearch/elasticsearch.tmp

RUN wget -q -O - https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-${ek_version}.tar.gz \
 |  tar -zx \
 && mv elasticsearch-${ek_version} elasticsearch \
 && mkdir -p ${ES_TMPDIR} \
 && wget -q -O - https://artifacts.elastic.co/downloads/kibana/kibana-${ek_version}-linux-x86_64.tar.gz \
 |  tar -zx \
 && mv kibana-${ek_version}-linux-x86_64 kibana \
 && rm -f kibana/node/bin/node kibana/node/bin/npm \
 && ln -s $(which node) kibana/node/bin/node \
 && ln -s $(which npm) kibana/node/bin/npm

CMD sh elasticsearch/bin/elasticsearch -E http.host=0.0.0.0 --quiet & kibana/bin/kibana --host 0.0.0.0 -Q

EXPOSE 9200 5601