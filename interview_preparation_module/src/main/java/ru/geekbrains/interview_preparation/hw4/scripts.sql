/*	ошибки в расписании (фильмы накладываются друг на друга),
	отсортированные по возрастанию времени.
	Выводить надо колонки «фильм 1», «время начала», «длительность», «фильм 2», «время начала», «длительность»;
*/

with t1 as (
select	s.id,
	s.movie_id,
    m.title,
	m.movie_length,
    s.session_time,
	s.session_time + m.movie_length as end_time
from cinema.sessions s
join cinema.movies m on s.movie_id = m.id
), t2 as (
select	s.id,
	s.movie_id,
    m.title,
	m.movie_length,
    s.session_time,
	s.session_time + m.movie_length as end_time
from cinema.sessions s
join cinema.movies m on s.movie_id = m.id
) select t1.title as 'фильм_1',
	t1.session_time as 'время начала',
	t1.movie_length as 'длительность',
	t2.title as 'фильм_2',
	t2.session_time as 'время начала',
	t2.movie_length as 'длительность'
from	t1,	t2
where	t1.session_time < t2.session_time
and		t1.end_time >= t2.session_time
order by t1.end_time - t2.session_time desc;

/*	перерывы 30 минут и более между фильмами — выводить по уменьшению длительности перерыва.
	Колонки «фильм 1», «время начала», «длительность», «время начала второго фильма», «длительность перерыва»;
*/

with t1 as (
select	s.id,
	s.movie_id,
    m.title,
	m.movie_length,
    s.session_time,
	s.session_time + m.movie_length as end_time
from cinema.sessions s
join cinema.movies m on s.movie_id = m.id
), t2 as (
select	s.id,
	s.movie_id,
    m.title,
	m.movie_length,
    s.session_time,
	s.session_time + m.movie_length as end_time
from cinema.sessions s
join cinema.movies m on s.movie_id = m.id
) select t1.title as 'фильм_1',
	t1.session_time as 'время начала',
	t1.movie_length as 'длительность',
    t2.title as 'фильм_2',
	t2.session_time as 'время начала',
	t2.movie_length as 'длительность',
    timediff(t2.session_time, t1.end_time) as 'длительность перерыва'
from	t1,	t2
where 	t2.session_time - t1.end_time > 3000
and 	t2.end_time - t1.end_time < (select max(movie_length) from cinema.movies)
order by t2.session_time - t1.end_time desc;

/*	список фильмов, для каждого — с указанием общего числа посетителей за все время,
	среднего числа зрителей за сеанс и общей суммы сборов по каждому фильму (отсортировать по убыванию прибыли).
	Внизу таблицы должна быть строчка «итого», содержащая данные по всем фильмам сразу;
*/
with Table1 as (
	select (select title from cinema.movies where id = s.movie_id) as title,
			s.movie_id,
			count(t.id) as visitors,
			sum(s.session_price) as session_income
	from cinema.sessions s
	join cinema.tickets t on t.session_id = s.id
	group by s.id)
select	t1.title as 'Фильм',
	sum(t1.visitors) as 'посетителей всего',
	round(sum(t1.visitors) / count(t1.movie_id)) as 'посетителей в среднем',
	sum(t1.session_income) as profit
from Table1 t1
group by t1.title
#тут нужно упорядочить но после этого нельзя делать объединение
union all

select 	'Итого:' as 'Фильм',
	count(t.id) as 'посетителей всего',
	round(count(t.id)/count(distinct s.id)) as 'посетителей в среднем',
    sum(s.session_price) as profit
from cinema.sessions s
join cinema.tickets t on t.session_id = s.id

/*	число посетителей и кассовые сборы, сгруппированные по времени начала фильма:
	с 9 до 15, с 15 до 18, с 18 до 21, с 21 до 00:00 (сколько посетителей пришло с 9 до 15 часов и т.д.).
*/

select	'c 9 до 15' as 'интервал',
		count(t.id) as 'число посетителей',
		sum(s.session_price) as 'кассовые сборы'
from	cinema.sessions s
join	cinema.tickets t on s.id = t.session_id
where	cast(s.session_time as time) > '09:00:00' and cast(s.session_time as time) <= '15:00:00'

union all

select	'c 15 до 18' as 'интервал',
		count(t.id) as 'число посетителей',
		sum(s.session_price) as 'кассовые сборы'
from	cinema.sessions s
join	cinema.tickets t on s.id = t.session_id
where	cast(s.session_time as time) > '15:00:00' and cast(s.session_time as time) <= '18:00:00'

union all

select	'c 18 до 21' as 'интервал',
		count(t.id) as 'число посетителей',
		sum(s.session_price) as 'кассовые сборы'
from	cinema.sessions s
join	cinema.tickets t on s.id = t.session_id
where	cast(s.session_time as time) > '18:00:00' and cast(s.session_time as time) <= '21:00:00'

union all

select	'c 21 до 00' as 'интервал',
		count(t.id) as 'число посетителей',
		sum(s.session_price) as 'кассовые сборы'
from	cinema.sessions s
join	cinema.tickets t on s.id = t.session_id
where	cast(s.session_time as time) > '21:00:00' and cast(s.session_time as time) <= '23:59:59'