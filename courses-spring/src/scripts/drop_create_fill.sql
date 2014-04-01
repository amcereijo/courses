drop table courses.courses;
drop table courses.authors;
drop table courses.levels;

create table courses.levels(id bigint auto_increment 	primary key, name varchar(50));

create table courses.authors (
	id bigint auto_increment primary key,
	name varchar(100)
);

create table courses.courses (
	id bigint auto_increment primary key,
	title varchar(100),
	id_level bigint,
	hours int,
	active boolean,
	id_author bigint,
	FOREIGN KEY (id_author) 
        REFERENCES courses.authors(id)
        ON DELETE CASCADE,
    FOREIGN KEY (id_level) 
        REFERENCES courses.levels(id)
        ON DELETE CASCADE
);




insert into courses.authors(id, name) values(1,'Angel Cereijo Martinez');
insert into courses.authors(id, name) values(2,'Steve Jobs');
insert into courses.authors(id, name) values(3,'Will Smith');
insert into courses.authors(id, name) values(4,'Bruce Willies');


insert into courses.levels(id, name) values(1 ,'Básico');
insert into courses.levels(id, name) values(2 ,'Intermedio');
insert into courses.levels(id, name) values(3 ,'Avanzado');

insert into courses.courses(id, title, id_level, hours, active, id_author) 
					values ( 1, 'My first course', 1,10, 0, 1);
insert into courses.courses(id, title, id_level, hours, active, id_author) 
					values ( 2, 'Never ending course', 2, 25, 0, 1);
insert into courses.courses(id, title, id_level, hours, active, id_author) 
					values ( 3, 'Expert course', 3, 100, 0, 3);