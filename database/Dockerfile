FROM mysql:latest

WORKDIR /database

ADD ./cinemadb-b.sql /docker-entrypoint-initdb.d/ 

EXPOSE 3306

ENV MYSQL_ALLOW_EMPTY_PASSWORD=true
ENV MYSQL_USER=cinema
ENV MYSQL_PASSWORD=cinema
