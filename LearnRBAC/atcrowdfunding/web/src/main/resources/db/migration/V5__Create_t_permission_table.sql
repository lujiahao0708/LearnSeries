create table t_permission
(
    id int auto_increment primary key not null,
    name varchar(256),
    url varchar(256),
    pid bigint,
    icon varchar(256)
);
