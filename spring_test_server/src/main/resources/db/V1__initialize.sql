create table students
(
    id   bigint primary key AUTO_INCREMENT,
    name varchar(30) not null,
    age  int not null
);

insert into students (id, name, age)
values (1, 'Bob', 30),
       (2, 'Bill', 33),
       (3, 'Tod', 27),
       (4, 'Jeff', 22),
       (5, 'Tom', 25),
       (6, 'Dan', 28);
