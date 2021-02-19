drop database if exists cinema;

create database cinema;

create table cinema.movies(
	id bigint not null primary key auto_increment,
	title char(255) not null,
	movie_length time not null default '01:00:00'
);

insert into cinema.movies(title, movie_length) values
	("Star Wars", '02:00:00'),
	("Guiardians", '01:30:00'),
	("Hobbit", '02:00:00'),
	("Rambo", '02:00:00'),
	("Smeshariki", '01:30:00');

create table cinema.sessions(
	id bigint not null primary key auto_increment,
	movie_id bigint not null,
	session_time datetime not null default CURRENT_TIMESTAMP,
	session_price double not null default 300.00,
	foreign key (movie_id) references movies (id)
);

insert into cinema.sessions(movie_id, session_time, session_price) values
	(1, '2021-02-12 10:00:00', 350.00),
	(2, '2021-02-12 11:00:00', 200.00),
	(5, '2021-02-12 12:45:00', 300.00),
	(3, '2021-02-12 14:00:00', 300.00),
	(2, '2021-02-12 16:15:00', 250.00),
	(5, '2021-02-12 17:00:00', 200.00),
	(4, '2021-02-12 19:15:00', 400.00),
	(3, '2021-02-12 20:00:00', 450.00),
	(5, '2021-02-12 22:00:00', 350.00);

create table cinema.tickets(
	id bigint not null primary key auto_increment,
	session_id bigint not null,
	foreign key (session_id) references sessions (id)
);

insert into cinema.tickets(session_id) values
	(1), 	(1), 	(1),	(1),	(1),	(1),	(1),
	(2),	(2),	(2),	(2),	(2),
	(3),	(3),	(3),	(3),	(3),	(3),
	(4),	(4),	(4),	(4),	(5),
	(5),	(5),	(5),
	(6),	(6),	(6),	(6),	(6),
	(7),	(7),	(7),	(7),	(7),	(7),	(7),	(7),
    (8),	(8),	(8),	(8),	(8),
    (9),	(9),	(9),	(9),	(9),	(9),	(9),	(9),	(9);