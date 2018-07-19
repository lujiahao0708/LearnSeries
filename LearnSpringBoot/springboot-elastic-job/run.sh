#!/bin/sh

export JAVA_HOME=/usr/local/java
export CLASSPATH=.:$JAVA_HOME/lib:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
export PATH=$JAVA_HOME/bin:$PATH


#1,start supervisord
/usr/bin/supervisord &

#2,start tomcat
cd /u01/springboot-elastic-job/

java  ${JAVA_OPTS} -jar springboot-elastic-job-0.0.1.jar --spring.profiles.active=${START_ENV}

#3,process