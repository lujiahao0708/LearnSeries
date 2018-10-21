FROM sssllc/centos7.2-jdk1.8

ENV START_ENV dev

MAINTAINER lujiahao@gmail.com

#mkdir code
RUN mkdir -p /u01/springboot-elastic-job

# add code
ADD run.sh target/springboot-elastic-job-0.0.1.jar /u01/springboot-elastic-job/

# chmod
RUN chmod 775 /u01/springboot-elastic-job/run.sh && \
    chmod +x  /u01/springboot-elastic-job/run.sh

# entrypoint
ENTRYPOINT /u01/springboot-elastic-job/run.sh