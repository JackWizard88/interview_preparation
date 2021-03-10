create table students
(
    id   bigint primary key AUTO_INCREMENT,
    name varchar(30) not null,
    age  int         not null
);

insert into students (id, name, age)
values (1, 'Bob', 30),
       (2, 'Bill', 33),
       (3, 'Tod', 27),
       (4, 'Jeff', 22),
       (5, 'Tom', 25),
       (6, 'Dan', 28);

create table users
(
    id       bigint primary key AUTO_INCREMENT,
    username varchar(30) not null,
    password varchar(80) not null,
    email    varchar(50) unique
);

create table roles
(
    id   bigint primary key AUTO_INCREMENT,
    name varchar(50) not null
);

create table privileges
(
    id   bigint primary key AUTO_INCREMENT,
    name varchar(50) not null
);

create table roles_privileges
(
    role_id      bigint not null,
    privilege_id bigint not null,
    primary key (privilege_id, role_id),
    foreign key (role_id) references roles (id),
    foreign key (privilege_id) references privileges (id)
);

create table users_roles
(
    user_id bigint not null,
    role_id bigint not null,
    primary key (user_id, role_id),
    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id)
);

insert into roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN'),
       ('ROLE_MANAGER');

insert into privileges (name)
values ('READ_PRIVILEGE'), ('WRITE_PRIVILEGE'), ('GOD_PRIVILEGE');

insert into users (username, password, email)
values ('admin', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'admin@gmail.com'),
       ('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'user@gmail.com');

insert into roles_privileges (role_id, privilege_id)
values (1, 1),
       (2, 1),
       (2, 2),
       (2, 3),
       (3, 1),
       (3, 2);

insert into users_roles (user_id, role_id)
values (1, 1),
       (1, 2),
       (2, 1);
