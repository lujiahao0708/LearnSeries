create table t_role_permission
(
    id int auto_increment primary key not null,
    roleid bigint,
    permissionid bigint
);