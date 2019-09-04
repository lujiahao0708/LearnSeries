FROM centos
MAINTAINER lujiahao<lujiahao0708@gmail.com>

ENV MYPATH /usr/local
WORKDIR $MYPATH

RUN yum -y install vim
RUN yum -y install net-tools

EXPOSE 80

CMD echo $MYPATH
CMD echo "success  ok"
CMD /bin/bash 
