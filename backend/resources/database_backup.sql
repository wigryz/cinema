CREATE SCHEMA cinemadb;

CREATE TABLE cinemadb.cinema_user ( 
	id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	username             varchar(100)  NOT NULL    ,
	password             varchar(256)  NOT NULL    ,
	email                varchar(100)  NOT NULL    ,
	created_at           datetime  NOT NULL DEFAULT CURRENT_TIMESTAMP   
 ) engine=InnoDB;

CREATE TABLE cinemadb.genre ( 
	id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	name                 char(20)  NOT NULL    ,
	CONSTRAINT unq_genre UNIQUE ( name ) 
 );

CREATE TABLE cinemadb.movie ( 
	id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	title                char(100)      ,
	short_description    tinytext      ,
	description          text      ,
	year_of_production   int      ,
	duration             int      ,
	additional_info      char(50)      ,
	age_restriction      int      ,
	poster_path          char(100)      
 );

CREATE TABLE cinemadb.movie_genre ( 
	movie_id             int  NOT NULL    ,
	genre_id             int  NOT NULL    ,
	CONSTRAINT pk_movie_genre PRIMARY KEY ( movie_id, genre_id ),
	CONSTRAINT fk_movie_category_category FOREIGN KEY ( genre_id ) REFERENCES cinemadb.genre( id ) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT fk_movie_category_movie FOREIGN KEY ( movie_id ) REFERENCES cinemadb.movie( id ) ON DELETE RESTRICT ON UPDATE RESTRICT
 );

CREATE INDEX fk_movie_category_category ON cinemadb.movie_genre ( genre_id );

CREATE TABLE cinemadb.person ( 
	id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	first_name           char(20)  NOT NULL    ,
	second_name          char(20)      ,
	last_name            char(20)  NOT NULL    ,
	portrait_path        char(100)      
 );

CREATE TABLE cinemadb.role ( 
	id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	name                 varchar(30)  NOT NULL    
 ) engine=InnoDB;

CREATE TABLE cinemadb.technology ( 
	id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	name                 char(2)  NOT NULL    ,
	CONSTRAINT unq_technology UNIQUE ( name ) 
 );

CREATE TABLE cinemadb.user_role ( 
	user_id              int  NOT NULL    ,
	role_id              int  NOT NULL    ,
	CONSTRAINT fk_user_role_cinema_user FOREIGN KEY ( user_id ) REFERENCES cinemadb.cinema_user( id ) ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT fk_user_role_role FOREIGN KEY ( role_id ) REFERENCES cinemadb.role( id ) ON DELETE NO ACTION ON UPDATE NO ACTION
 ) engine=InnoDB;

CREATE INDEX fk_user_role_cinema_user ON cinemadb.user_role ( user_id );

CREATE INDEX fk_user_role_role ON cinemadb.user_role ( role_id );

CREATE TABLE cinemadb.movie_actor ( 
	movie_id             int  NOT NULL    ,
	person_id            int  NOT NULL    ,
	CONSTRAINT pk_movie_actor PRIMARY KEY ( movie_id, person_id ),
	CONSTRAINT fk_movie_actor_movie FOREIGN KEY ( movie_id ) REFERENCES cinemadb.movie( id ) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT fk_movie_actor_person FOREIGN KEY ( person_id ) REFERENCES cinemadb.person( id ) ON DELETE RESTRICT ON UPDATE RESTRICT
 );

CREATE INDEX fk_movie_actor_person ON cinemadb.movie_actor ( person_id );

CREATE TABLE cinemadb.movie_director ( 
	movie_id             int  NOT NULL    ,
	person_id            int  NOT NULL    ,
	CONSTRAINT pk_movie_director PRIMARY KEY ( movie_id, person_id ),
	CONSTRAINT fk_director_movie_movie FOREIGN KEY ( movie_id ) REFERENCES cinemadb.movie( id ) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT fk_director_movie_person FOREIGN KEY ( person_id ) REFERENCES cinemadb.person( id ) ON DELETE RESTRICT ON UPDATE RESTRICT
 );

CREATE INDEX fk_director_movie_person ON cinemadb.movie_director ( person_id );

CREATE TABLE cinemadb.showtime ( 
	id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	movie_id             int  NOT NULL    ,
	technology_id        int  NOT NULL    ,
	language             enum('dubbing','subtitles')      ,
	`datetime`           datetime  NOT NULL    ,
	CONSTRAINT fk_showtime_movie FOREIGN KEY ( movie_id ) REFERENCES cinemadb.movie( id ) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT fk_showtime_technology FOREIGN KEY ( technology_id ) REFERENCES cinemadb.technology( id ) ON DELETE RESTRICT ON UPDATE RESTRICT
 );

CREATE INDEX fk_showtime_movie ON cinemadb.showtime ( movie_id );

CREATE INDEX fk_showtime_technology ON cinemadb.showtime ( technology_id );

INSERT INTO cinemadb.cinema_user( id, username, password, email, created_at ) VALUES ( 1, 'user', 'user', 'user@gmail.com', '2021-10-16 05.41.57 PM');
INSERT INTO cinemadb.cinema_user( id, username, password, email, created_at ) VALUES ( 2, 'admin', 'admin', 'admin@gmail.com', '2021-10-16 05.41.57 PM');
INSERT INTO cinemadb.genre( id, name ) VALUES ( 6, 'Animation');
INSERT INTO cinemadb.genre( id, name ) VALUES ( 4, 'Comedy');
INSERT INTO cinemadb.genre( id, name ) VALUES ( 3, 'Documentary');
INSERT INTO cinemadb.genre( id, name ) VALUES ( 1, 'Horror');
INSERT INTO cinemadb.genre( id, name ) VALUES ( 5, 'Romantic comedy');
INSERT INTO cinemadb.genre( id, name ) VALUES ( 8, 'Thriller');
INSERT INTO cinemadb.genre( id, name ) VALUES ( 2, 'War Film');
INSERT INTO cinemadb.genre( id, name ) VALUES ( 7, 'Western');
INSERT INTO cinemadb.movie( id, title, short_description, description, year_of_production, duration, additional_info, age_restriction, poster_path ) VALUES ( 1, 'John is visiting Mike.', 'Anne bought new car. Anne bought new car. Tony bought new car. Anne has free time. Anne is walking. ', 'Anne bought new car. Anne is shopping. Tony bought new car. Tony is walking. Tony has free time. ', 2008, 81, 'Mike like sports. Rudi watches football.', 13, 'resources/posters/rqb.doc');
INSERT INTO cinemadb.movie( id, title, short_description, description, year_of_production, duration, additional_info, age_restriction, poster_path ) VALUES ( 2, 'Cindy called Adrian.', 'John bought new car. Anne is shopping. Tony bought new car. Tony bought new car. Tony has free time. ', 'John is shopping. John is shopping. John bought new car. John is walking. ', 2011, 118, 'I watches football. Mike loves flowers.', 15, 'resources/posters/mgbxc.asm');
INSERT INTO cinemadb.movie( id, title, short_description, description, year_of_production, duration, additional_info, age_restriction, poster_path ) VALUES ( 3, 'John knows Adrian.', 'John has free time. Tony is shopping. ', 'Anne bought new car. Anne is walking. John bought new car. John has free time. Tony is walking. ', 2012, 159, 'Mike watches football. Mike loves flowers.', 15, 'resources/posters/nak.txt');
INSERT INTO cinemadb.movie( id, title, short_description, description, year_of_production, duration, additional_info, age_restriction, poster_path ) VALUES ( 4, 'John called Mike.', 'John bought new car. Anne is walking. John bought new car. Anne has free time. John has free time. ', 'John bought new car. Anne is walking. Anne is walking. John is shopping. John is shopping. ', 2008, 143, 'Mike watches football. Rudi loves flowers.', 18, 'resources/posters/tqv.pdf');
INSERT INTO cinemadb.movie( id, title, short_description, description, year_of_production, duration, additional_info, age_restriction, poster_path ) VALUES ( 5, 'Cindy met Adrian.', 'Anne bought new car. Anne is shopping. ', 'Tony bought new car. Tony has free time. Tony bought new car. ', 2012, 101, 'I loves flowers. Mike loves flowers.', 15, 'resources/posters/qydm.asm');
INSERT INTO cinemadb.movie( id, title, short_description, description, year_of_production, duration, additional_info, age_restriction, poster_path ) VALUES ( 6, 'Cindy called Rolph.', 'Anne bought new car. Tony has free time. Tony bought new car. Tony has free time. Anne bought new car. ', 'Anne bought new car. Tony is shopping. Tony is shopping. Tony has free time. Anne bought new car. ', 2008, 86, 'Rudi watches football. Mike like swimming.', 15, 'resources/posters/ssh.xls');
INSERT INTO cinemadb.movie( id, title, short_description, description, year_of_production, duration, additional_info, age_restriction, poster_path ) VALUES ( 7, 'Cindy met Mike.', 'Tony bought new car. John bought new car. Tony has free time. ', 'Anne bought new car. Anne has free time. John bought new car. ', 2011, 147, 'Mike like swimming. Mike loves flowers.', 15, 'resources/posters/rxduh.bmp');
INSERT INTO cinemadb.movie( id, title, short_description, description, year_of_production, duration, additional_info, age_restriction, poster_path ) VALUES ( 8, 'Cindy called Adrian.', 'John bought new car. John is walking. John bought new car. John bought new car. Tony is walking. ', 'John is shopping. John bought new car. ', 2009, 86, 'Mike loves flowers. Mike watches football.', 18, 'resources/posters/tsuz.xls');
INSERT INTO cinemadb.movie( id, title, short_description, description, year_of_production, duration, additional_info, age_restriction, poster_path ) VALUES ( 9, 'I knows Mike.', 'Anne bought new car. John is shopping. Tony is shopping. Anne bought new car. John is walking. ', 'Anne bought new car. Anne bought new car. Tony bought new car. John bought new car. ', 2012, 62, 'Rudi watches football.', 15, 'resources/posters/odbe.txt');
INSERT INTO cinemadb.movie( id, title, short_description, description, year_of_production, duration, additional_info, age_restriction, poster_path ) VALUES ( 10, 'I called Tony.', 'John bought new car. Tony is walking. John has free time. John has free time. Anne has free time. ', 'Anne bought new car. Anne is shopping. John bought new car. Tony has free time. John is walking. ', 2012, 107, 'I loves flowers.', 15, 'resources/posters/ulpg.php');
INSERT INTO cinemadb.movie( id, title, short_description, description, year_of_production, duration, additional_info, age_restriction, poster_path ) VALUES ( 11, 'John knows Tony.', 'John is walking. Anne bought new car. Tony is shopping. John has free time. Tony is walking. ', 'Tony has free time. Anne is walking. John bought new car. Tony bought new car. Tony is shopping. ', 2011, 139, 'Mike watches football. Mike loves flowers.', 18, 'resources/posters/sdo.asm');
INSERT INTO cinemadb.movie( id, title, short_description, description, year_of_production, duration, additional_info, age_restriction, poster_path ) VALUES ( 12, 'John is visiting Florian.', 'Tony is shopping. Anne is walking. ', 'John is walking. John bought new car. John has free time. John has free time. John has free time. ', 2008, 93, 'I watches football.', 15, 'resources/posters/pyg.txt');
INSERT INTO cinemadb.movie( id, title, short_description, description, year_of_production, duration, additional_info, age_restriction, poster_path ) VALUES ( 13, 'John knows Mike.', 'John has free time. Tony is walking. ', 'Tony bought new car. Tony is walking. Tony bought new car. Tony has free time. ', 2008, 67, 'Mike watches football. Rudi loves flowers.', 15, 'resources/posters/ooji.doc');
INSERT INTO cinemadb.movie( id, title, short_description, description, year_of_production, duration, additional_info, age_restriction, poster_path ) VALUES ( 14, 'Cindy called Adrian.', 'Anne bought new car. Anne bought new car. Anne is shopping. Anne has free time. Tony bought new car. ', 'Anne has free time. Anne bought new car. Tony bought new car. ', 2008, 121, 'Rudi like sports. Mike watches football.', 15, 'resources/posters/jzp.bmp');
INSERT INTO cinemadb.movie( id, title, short_description, description, year_of_production, duration, additional_info, age_restriction, poster_path ) VALUES ( 15, 'Cindy knows Poe.', 'Anne is shopping. Anne is walking. John bought new car. John bought new car. John has free time. ', 'Tony is shopping. John has free time. John is walking. Tony has free time. John has free time. ', 2011, 126, 'Mike like swimming.', 13, 'resources/posters/tgf.bmp');
INSERT INTO cinemadb.movie( id, title, short_description, description, year_of_production, duration, additional_info, age_restriction, poster_path ) VALUES ( 16, 'John called Mike.', 'Tony is shopping. Anne is shopping. Anne is shopping. Tony bought new car. Tony has free time. ', 'Tony has free time. Tony is walking. John bought new car. Tony has free time. John has free time. ', 2011, 141, 'Mike watches football. Mike watches football.', 18, 'resources/posters/spn.asm');
INSERT INTO cinemadb.movie( id, title, short_description, description, year_of_production, duration, additional_info, age_restriction, poster_path ) VALUES ( 17, 'I called Rolph.', 'Anne is shopping. Anne bought new car. Tony is shopping. ', 'John bought new car. Tony is shopping. ', 2010, 116, 'Rudi watches football. Mike watches football.', 15, 'resources/posters/xja.asm');
INSERT INTO cinemadb.movie( id, title, short_description, description, year_of_production, duration, additional_info, age_restriction, poster_path ) VALUES ( 18, 'Cindy called Florian.', 'John has free time. Anne has free time. Tony bought new car. Anne has free time. John bought new car. ', 'Anne bought new car. John has free time. Tony is walking. ', 2011, 96, 'Mike like swimming. Mike loves flowers.', 15, 'resources/posters/izh.php');
INSERT INTO cinemadb.movie( id, title, short_description, description, year_of_production, duration, additional_info, age_restriction, poster_path ) VALUES ( 19, 'Cindy knows Poe.', 'Anne has free time. John is shopping. Anne bought new car. Anne bought new car. Tony is walking. ', 'Anne bought new car. Tony is shopping. ', 2011, 73, 'Mike watches football.', 13, 'resources/posters/fio.bmp');
INSERT INTO cinemadb.movie( id, title, short_description, description, year_of_production, duration, additional_info, age_restriction, poster_path ) VALUES ( 20, 'Cindy called Adrian.', 'Anne bought new car. John has free time. Tony is shopping. Tony has free time. Anne bought new car. ', 'John bought new car. Anne is walking. ', 2012, 143, 'Rudi like sports. I like sports.', 13, 'resources/posters/qlpnb.ini');
INSERT INTO cinemadb.movie_genre( movie_id, genre_id ) VALUES ( 4, 1);
INSERT INTO cinemadb.movie_genre( movie_id, genre_id ) VALUES ( 5, 1);
INSERT INTO cinemadb.movie_genre( movie_id, genre_id ) VALUES ( 6, 1);
INSERT INTO cinemadb.movie_genre( movie_id, genre_id ) VALUES ( 9, 1);
INSERT INTO cinemadb.movie_genre( movie_id, genre_id ) VALUES ( 13, 1);
INSERT INTO cinemadb.movie_genre( movie_id, genre_id ) VALUES ( 1, 2);
INSERT INTO cinemadb.movie_genre( movie_id, genre_id ) VALUES ( 6, 2);
INSERT INTO cinemadb.movie_genre( movie_id, genre_id ) VALUES ( 20, 2);
INSERT INTO cinemadb.movie_genre( movie_id, genre_id ) VALUES ( 3, 3);
INSERT INTO cinemadb.movie_genre( movie_id, genre_id ) VALUES ( 12, 3);
INSERT INTO cinemadb.movie_genre( movie_id, genre_id ) VALUES ( 15, 3);
INSERT INTO cinemadb.movie_genre( movie_id, genre_id ) VALUES ( 6, 4);
INSERT INTO cinemadb.movie_genre( movie_id, genre_id ) VALUES ( 8, 4);
INSERT INTO cinemadb.movie_genre( movie_id, genre_id ) VALUES ( 13, 4);
INSERT INTO cinemadb.movie_genre( movie_id, genre_id ) VALUES ( 1, 5);
INSERT INTO cinemadb.movie_genre( movie_id, genre_id ) VALUES ( 12, 5);
INSERT INTO cinemadb.movie_genre( movie_id, genre_id ) VALUES ( 20, 5);
INSERT INTO cinemadb.movie_genre( movie_id, genre_id ) VALUES ( 7, 6);
INSERT INTO cinemadb.movie_genre( movie_id, genre_id ) VALUES ( 11, 6);
INSERT INTO cinemadb.movie_genre( movie_id, genre_id ) VALUES ( 17, 6);
INSERT INTO cinemadb.movie_genre( movie_id, genre_id ) VALUES ( 1, 7);
INSERT INTO cinemadb.movie_genre( movie_id, genre_id ) VALUES ( 7, 7);
INSERT INTO cinemadb.movie_genre( movie_id, genre_id ) VALUES ( 8, 7);
INSERT INTO cinemadb.movie_genre( movie_id, genre_id ) VALUES ( 12, 7);
INSERT INTO cinemadb.movie_genre( movie_id, genre_id ) VALUES ( 18, 7);
INSERT INTO cinemadb.movie_genre( movie_id, genre_id ) VALUES ( 19, 7);
INSERT INTO cinemadb.movie_genre( movie_id, genre_id ) VALUES ( 20, 7);
INSERT INTO cinemadb.movie_genre( movie_id, genre_id ) VALUES ( 3, 8);
INSERT INTO cinemadb.movie_genre( movie_id, genre_id ) VALUES ( 15, 8);
INSERT INTO cinemadb.movie_genre( movie_id, genre_id ) VALUES ( 16, 8);
INSERT INTO cinemadb.person( id, first_name, second_name, last_name, portrait_path ) VALUES ( 1, 'Rapzapinex', 'Monfropepistor', 'Rapglibupentor', 'resources/portraits/tuwn.php');
INSERT INTO cinemadb.person( id, first_name, second_name, last_name, portrait_path ) VALUES ( 2, 'Lombanamantor', 'Winbanepor', 'Adtumplazz', 'resources/portraits/ziiv.php');
INSERT INTO cinemadb.person( id, first_name, second_name, last_name, portrait_path ) VALUES ( 3, 'Klibanollover', 'Incadadistor', 'Parsipplantor', 'resources/portraits/eudyrm.pdf');
INSERT INTO cinemadb.person( id, first_name, second_name, last_name, portrait_path ) VALUES ( 4, 'Admunover', null, 'Qwibanplor', 'resources/portraits/lhw.pdf');
INSERT INTO cinemadb.person( id, first_name, second_name, last_name, portrait_path ) VALUES ( 5, 'Undudplazz', 'Doptanplar', 'Renipackin', 'resources/portraits/pdi.ini');
INSERT INTO cinemadb.person( id, first_name, second_name, last_name, portrait_path ) VALUES ( 6, 'Aderplar', 'Revenollor', 'Trubanazz', 'resources/portraits/bat.ini');
INSERT INTO cinemadb.person( id, first_name, second_name, last_name, portrait_path ) VALUES ( 7, 'Vartanentor', 'Haperover', 'Ciphupepin', 'resources/portraits/vkink.asm');
INSERT INTO cinemadb.person( id, first_name, second_name, last_name, portrait_path ) VALUES ( 8, 'Happickamex', 'Moncadicistor', 'Ciperupower', 'resources/portraits/hoq.xls');
INSERT INTO cinemadb.person( id, first_name, second_name, last_name, portrait_path ) VALUES ( 9, 'Rerobepicator', 'Repebin', 'Supquestplax', 'resources/portraits/ayq.php');
INSERT INTO cinemadb.person( id, first_name, second_name, last_name, portrait_path ) VALUES ( 10, 'Thrukilanicator', 'Parwerpplor', 'Varglibommazz', 'resources/portraits/fpmy.bmp');
INSERT INTO cinemadb.person( id, first_name, second_name, last_name, portrait_path ) VALUES ( 11, 'Parerupax', 'Parerupax', 'Frowerexentor', 'resources/portraits/shd.asm');
INSERT INTO cinemadb.person( id, first_name, second_name, last_name, portrait_path ) VALUES ( 12, 'Tipdudower', 'Supmuninex', 'Varrobantor', 'resources/portraits/msyg.xls');
INSERT INTO cinemadb.person( id, first_name, second_name, last_name, portrait_path ) VALUES ( 13, 'Monmunazz', 'Zeekilplar', 'Trucadplor', 'resources/portraits/fkv.bmp');
INSERT INTO cinemadb.person( id, first_name, second_name, last_name, portrait_path ) VALUES ( 14, 'Varwerentor', 'Cipnipollar', 'Qwihupplicator', 'resources/portraits/gdrc.pdf');
INSERT INTO cinemadb.person( id, first_name, second_name, last_name, portrait_path ) VALUES ( 15, 'Cipglibupicator', 'Dopquestplistor', 'Barglibplan', 'resources/portraits/neiyns.pdf');
INSERT INTO cinemadb.person( id, first_name, second_name, last_name, portrait_path ) VALUES ( 16, 'Monwerazz', null, 'Raperinover', 'resources/portraits/gsc.txt');
INSERT INTO cinemadb.person( id, first_name, second_name, last_name, portrait_path ) VALUES ( 17, 'Grorobopicator', 'Unglibupover', 'Haphupupower', 'resources/portraits/mico.xls');
INSERT INTO cinemadb.person( id, first_name, second_name, last_name, portrait_path ) VALUES ( 18, 'Emhupackor', 'Cipquestupazz', 'Hapquestupicator', 'resources/portraits/cqtw.php');
INSERT INTO cinemadb.person( id, first_name, second_name, last_name, portrait_path ) VALUES ( 19, 'Gromunplor', 'Emsipax', 'Monvenamin', null);
INSERT INTO cinemadb.person( id, first_name, second_name, last_name, portrait_path ) VALUES ( 20, 'Tipfropanover', 'Barmunor', 'Trukilepan', null);
INSERT INTO cinemadb.role( id, name ) VALUES ( 1, 'ROLE_USER');
INSERT INTO cinemadb.role( id, name ) VALUES ( 2, 'ROLE_ADMIN');
INSERT INTO cinemadb.technology( id, name ) VALUES ( 1, '2D');
INSERT INTO cinemadb.technology( id, name ) VALUES ( 2, '3D');
INSERT INTO cinemadb.user_role( user_id, role_id ) VALUES ( 1, 1);
INSERT INTO cinemadb.user_role( user_id, role_id ) VALUES ( 2, 2);
INSERT INTO cinemadb.movie_actor( movie_id, person_id ) VALUES ( 6, 1);
INSERT INTO cinemadb.movie_actor( movie_id, person_id ) VALUES ( 7, 1);
INSERT INTO cinemadb.movie_actor( movie_id, person_id ) VALUES ( 11, 3);
INSERT INTO cinemadb.movie_actor( movie_id, person_id ) VALUES ( 17, 3);
INSERT INTO cinemadb.movie_actor( movie_id, person_id ) VALUES ( 6, 4);
INSERT INTO cinemadb.movie_actor( movie_id, person_id ) VALUES ( 8, 4);
INSERT INTO cinemadb.movie_actor( movie_id, person_id ) VALUES ( 13, 4);
INSERT INTO cinemadb.movie_actor( movie_id, person_id ) VALUES ( 13, 5);
INSERT INTO cinemadb.movie_actor( movie_id, person_id ) VALUES ( 3, 6);
INSERT INTO cinemadb.movie_actor( movie_id, person_id ) VALUES ( 12, 7);
INSERT INTO cinemadb.movie_actor( movie_id, person_id ) VALUES ( 6, 8);
INSERT INTO cinemadb.movie_actor( movie_id, person_id ) VALUES ( 15, 8);
INSERT INTO cinemadb.movie_actor( movie_id, person_id ) VALUES ( 5, 9);
INSERT INTO cinemadb.movie_actor( movie_id, person_id ) VALUES ( 13, 9);
INSERT INTO cinemadb.movie_actor( movie_id, person_id ) VALUES ( 4, 10);
INSERT INTO cinemadb.movie_actor( movie_id, person_id ) VALUES ( 1, 11);
INSERT INTO cinemadb.movie_actor( movie_id, person_id ) VALUES ( 12, 12);
INSERT INTO cinemadb.movie_actor( movie_id, person_id ) VALUES ( 20, 12);
INSERT INTO cinemadb.movie_actor( movie_id, person_id ) VALUES ( 3, 14);
INSERT INTO cinemadb.movie_actor( movie_id, person_id ) VALUES ( 15, 15);
INSERT INTO cinemadb.movie_actor( movie_id, person_id ) VALUES ( 16, 15);
INSERT INTO cinemadb.movie_actor( movie_id, person_id ) VALUES ( 20, 16);
INSERT INTO cinemadb.movie_actor( movie_id, person_id ) VALUES ( 1, 18);
INSERT INTO cinemadb.movie_actor( movie_id, person_id ) VALUES ( 1, 19);
INSERT INTO cinemadb.movie_actor( movie_id, person_id ) VALUES ( 7, 19);
INSERT INTO cinemadb.movie_actor( movie_id, person_id ) VALUES ( 18, 19);
INSERT INTO cinemadb.movie_actor( movie_id, person_id ) VALUES ( 19, 19);
INSERT INTO cinemadb.movie_actor( movie_id, person_id ) VALUES ( 20, 19);
INSERT INTO cinemadb.movie_actor( movie_id, person_id ) VALUES ( 8, 20);
INSERT INTO cinemadb.movie_actor( movie_id, person_id ) VALUES ( 12, 20);
INSERT INTO cinemadb.movie_director( movie_id, person_id ) VALUES ( 7, 1);
INSERT INTO cinemadb.movie_director( movie_id, person_id ) VALUES ( 17, 3);
INSERT INTO cinemadb.movie_director( movie_id, person_id ) VALUES ( 6, 4);
INSERT INTO cinemadb.movie_director( movie_id, person_id ) VALUES ( 8, 4);
INSERT INTO cinemadb.movie_director( movie_id, person_id ) VALUES ( 13, 4);
INSERT INTO cinemadb.movie_director( movie_id, person_id ) VALUES ( 13, 5);
INSERT INTO cinemadb.movie_director( movie_id, person_id ) VALUES ( 3, 6);
INSERT INTO cinemadb.movie_director( movie_id, person_id ) VALUES ( 3, 7);
INSERT INTO cinemadb.movie_director( movie_id, person_id ) VALUES ( 12, 7);
INSERT INTO cinemadb.movie_director( movie_id, person_id ) VALUES ( 6, 8);
INSERT INTO cinemadb.movie_director( movie_id, person_id ) VALUES ( 15, 8);
INSERT INTO cinemadb.movie_director( movie_id, person_id ) VALUES ( 5, 9);
INSERT INTO cinemadb.movie_director( movie_id, person_id ) VALUES ( 13, 9);
INSERT INTO cinemadb.movie_director( movie_id, person_id ) VALUES ( 4, 10);
INSERT INTO cinemadb.movie_director( movie_id, person_id ) VALUES ( 1, 11);
INSERT INTO cinemadb.movie_director( movie_id, person_id ) VALUES ( 20, 12);
INSERT INTO cinemadb.movie_director( movie_id, person_id ) VALUES ( 15, 15);
INSERT INTO cinemadb.movie_director( movie_id, person_id ) VALUES ( 16, 15);
INSERT INTO cinemadb.movie_director( movie_id, person_id ) VALUES ( 1, 19);
INSERT INTO cinemadb.movie_director( movie_id, person_id ) VALUES ( 7, 19);
INSERT INTO cinemadb.movie_director( movie_id, person_id ) VALUES ( 18, 19);
INSERT INTO cinemadb.movie_director( movie_id, person_id ) VALUES ( 19, 19);
INSERT INTO cinemadb.movie_director( movie_id, person_id ) VALUES ( 20, 19);
INSERT INTO cinemadb.movie_director( movie_id, person_id ) VALUES ( 8, 20);
INSERT INTO cinemadb.movie_director( movie_id, person_id ) VALUES ( 12, 20);
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 1, 15, 2, 'dubbing', '2021-05-25 04.08.20 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 2, 3, 1, 'dubbing', '2021-07-29 06.18.44 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 3, 9, 2, 'dubbing', '2021-08-02 07.56.04 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 4, 9, 1, 'dubbing', '2021-06-23 09.56.18 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 5, 5, 1, 'subtitles', '2021-08-02 06.59.56 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 6, 1, 2, 'dubbing', '2020-11-19 10.50.20 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 7, 7, 2, 'dubbing', '2021-05-07 12.55.16 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 8, 14, 1, 'dubbing', '2020-12-13 06.46.27 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 9, 20, 2, 'subtitles', '2020-09-29 02.40.36 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 10, 15, 2, 'dubbing', '2021-03-01 08.35.11 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 11, 1, 2, 'subtitles', '2020-09-10 01.22.00 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 12, 4, 1, 'subtitles', '2021-07-09 04.55.06 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 13, 20, 1, 'dubbing', '2021-05-14 05.26.40 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 14, 4, 2, 'subtitles', '2021-06-19 05.02.08 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 15, 19, 1, 'subtitles', '2021-06-21 07.14.53 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 16, 12, 2, 'dubbing', '2020-12-07 05.11.48 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 17, 19, 2, 'subtitles', '2020-10-26 03.47.34 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 18, 19, 1, 'subtitles', '2021-03-29 05.06.49 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 19, 19, 2, 'dubbing', '2021-08-04 11.19.47 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 20, 10, 2, 'subtitles', '2021-02-01 09.52.17 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 21, 8, 1, 'subtitles', '2021-06-06 07.11.54 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 22, 19, 1, 'dubbing', '2021-05-20 05.18.07 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 23, 7, 2, 'subtitles', '2020-09-02 05.36.52 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 24, 4, 2, 'dubbing', '2021-03-14 03.51.16 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 25, 6, 2, 'subtitles', '2021-05-27 07.04.01 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 26, 8, 1, 'subtitles', '2021-01-10 12.51.24 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 27, 11, 1, 'subtitles', '2021-08-16 12.29.18 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 28, 18, 1, 'subtitles', '2021-02-13 01.20.28 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 29, 3, 1, 'subtitles', '2021-06-28 03.09.58 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 30, 11, 2, 'subtitles', '2020-10-18 05.13.45 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 31, 16, 1, 'dubbing', '2020-11-08 07.51.45 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 32, 12, 2, 'subtitles', '2021-04-24 06.24.03 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 33, 14, 2, 'subtitles', '2020-12-28 11.37.30 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 34, 1, 2, 'subtitles', '2021-01-28 07.21.55 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 35, 4, 2, 'dubbing', '2021-06-02 07.33.52 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 36, 16, 1, 'subtitles', '2020-11-08 10.30.12 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 37, 8, 1, 'dubbing', '2020-12-12 07.28.30 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 38, 13, 2, 'dubbing', '2021-02-12 02.42.50 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 39, 3, 1, 'subtitles', '2020-11-23 10.47.51 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 40, 18, 1, 'subtitles', '2021-04-03 05.45.18 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 41, 14, 2, 'subtitles', '2021-06-22 06.46.57 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 42, 10, 1, 'dubbing', '2021-05-27 04.51.00 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 43, 17, 2, 'subtitles', '2021-06-05 02.42.07 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 44, 1, 2, 'dubbing', '2021-01-30 10.26.16 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 45, 1, 1, 'subtitles', '2021-06-13 04.51.29 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 46, 18, 1, 'dubbing', '2021-02-18 02.43.34 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 47, 11, 1, 'dubbing', '2021-07-23 11.25.13 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 48, 1, 2, 'dubbing', '2021-01-18 11.04.02 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 49, 15, 2, 'dubbing', '2021-03-11 05.38.56 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 50, 15, 2, 'dubbing', '2021-06-13 06.59.25 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 51, 3, 1, 'dubbing', '2020-09-19 06.26.13 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 52, 6, 2, 'subtitles', '2021-07-13 03.58.02 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 53, 10, 2, 'subtitles', '2021-01-05 01.05.56 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 54, 2, 1, 'subtitles', '2020-10-16 08.13.29 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 55, 11, 2, 'dubbing', '2021-02-23 05.40.35 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 56, 13, 2, 'dubbing', '2021-02-26 04.53.28 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 57, 12, 1, 'dubbing', '2021-07-28 09.39.13 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 58, 20, 2, 'dubbing', '2020-11-06 03.32.42 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 59, 5, 2, null, '2021-03-28 05.17.28 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 60, 6, 1, 'dubbing', '2021-03-16 10.34.21 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 61, 13, 2, 'dubbing', '2021-03-23 12.44.04 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 62, 4, 2, 'subtitles', '2021-07-04 04.06.41 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 63, 4, 2, 'subtitles', '2021-03-28 04.35.30 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 64, 1, 1, 'dubbing', '2021-08-29 01.37.09 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 65, 1, 1, 'dubbing', '2021-07-25 03.22.00 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 66, 14, 2, 'dubbing', '2021-03-17 12.39.29 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 67, 4, 1, 'dubbing', '2020-11-18 06.07.34 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 68, 10, 1, 'dubbing', '2021-07-14 03.40.14 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 69, 4, 1, 'dubbing', '2020-12-27 11.30.37 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 70, 10, 2, 'subtitles', '2020-10-17 11.18.46 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 71, 11, 2, 'dubbing', '2020-10-25 01.37.53 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 72, 3, 2, 'subtitles', '2021-03-04 01.23.11 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 73, 20, 1, 'dubbing', '2021-05-07 12.10.05 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 74, 3, 2, 'dubbing', '2021-02-13 01.20.52 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 75, 5, 2, 'dubbing', '2021-08-08 07.15.46 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 76, 5, 1, 'subtitles', '2021-01-16 04.04.03 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 77, 8, 1, 'subtitles', '2021-03-25 12.08.46 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 78, 17, 1, 'dubbing', '2021-03-25 01.03.29 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 79, 5, 1, 'subtitles', '2020-12-16 03.53.18 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 80, 9, 2, 'dubbing', '2021-06-30 02.33.28 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 81, 9, 1, 'dubbing', '2021-06-24 09.15.58 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 82, 19, 1, 'subtitles', '2021-03-26 01.00.09 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 83, 5, 1, 'subtitles', '2021-01-01 08.58.38 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 84, 11, 2, 'dubbing', '2021-02-23 05.40.34 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 85, 18, 1, 'subtitles', '2021-05-22 11.46.16 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 86, 8, 1, 'subtitles', '2021-01-30 03.07.13 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 87, 1, 1, 'subtitles', '2021-04-13 11.10.11 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 88, 6, 1, 'subtitles', '2020-10-26 02.31.36 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 89, 12, 1, 'subtitles', '2021-05-20 03.13.07 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 90, 3, 1, 'subtitles', '2021-07-04 11.47.25 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 91, 14, 1, 'subtitles', '2020-09-21 09.21.37 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 92, 5, 2, 'dubbing', '2021-05-02 09.35.45 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 93, 3, 2, 'subtitles', '2021-02-12 07.56.24 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 94, 20, 1, 'subtitles', '2021-05-22 11.15.01 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 95, 14, 2, 'dubbing', '2021-03-14 12.19.24 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 96, 12, 2, 'subtitles', '2021-04-04 06.00.36 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 97, 20, 1, 'subtitles', '2021-04-16 12.33.59 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 98, 20, 2, 'dubbing', '2020-09-02 01.42.45 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 99, 5, 2, 'dubbing', '2021-05-10 10.39.24 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 100, 6, 2, 'dubbing', '2021-08-28 03.26.54 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 101, 8, 2, 'subtitles', '2021-07-13 04.27.09 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 102, 8, 1, 'subtitles', '2020-12-22 01.14.47 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 103, 10, 1, 'dubbing', '2021-03-03 11.06.21 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 104, 18, 1, 'subtitles', '2020-12-29 05.06.21 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 105, 7, 1, 'dubbing', '2021-03-01 09.20.41 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 106, 6, 2, 'dubbing', '2021-07-11 11.39.29 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 107, 9, 1, 'subtitles', '2021-05-25 12.01.59 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 108, 2, 2, 'subtitles', '2021-01-06 07.22.01 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 109, 11, 1, 'dubbing', '2021-07-02 09.14.28 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 110, 4, 1, 'subtitles', '2021-07-26 05.03.59 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 111, 20, 2, 'dubbing', '2021-02-06 01.39.57 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 112, 13, 2, 'dubbing', '2021-02-20 08.20.07 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 113, 13, 1, 'dubbing', '2020-10-30 03.11.29 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 114, 6, 1, 'subtitles', '2020-12-27 11.05.13 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 115, 19, 1, 'subtitles', '2021-04-29 03.22.53 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 116, 7, 1, 'dubbing', '2021-01-30 08.18.57 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 117, 11, 2, 'subtitles', '2021-01-18 03.25.11 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 118, 6, 2, 'dubbing', '2021-04-17 06.05.26 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 119, 10, 2, 'dubbing', '2021-02-14 12.11.20 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 120, 3, 1, 'dubbing', '2020-09-13 10.30.27 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 121, 9, 1, 'dubbing', '2021-06-30 01.25.35 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 122, 3, 1, 'subtitles', '2021-08-23 01.07.47 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 123, 7, 2, 'subtitles', '2020-09-22 05.06.07 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 124, 11, 2, 'dubbing', '2021-02-20 12.26.59 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 125, 15, 2, 'dubbing', '2021-07-03 02.06.33 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 126, 10, 2, 'dubbing', '2020-10-13 05.06.43 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 127, 20, 1, 'dubbing', '2021-02-07 06.29.48 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 128, 1, 2, 'subtitles', '2020-10-04 07.38.35 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 129, 5, 2, 'dubbing', '2021-03-07 10.55.47 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 130, 8, 1, 'subtitles', '2021-02-21 01.39.25 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 131, 4, 1, 'subtitles', '2020-12-21 12.56.31 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 132, 5, 2, 'dubbing', '2021-05-07 05.59.01 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 133, 11, 1, 'dubbing', '2021-04-21 02.59.25 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 134, 17, 2, 'subtitles', '2021-06-16 09.50.45 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 135, 12, 1, 'dubbing', '2021-05-20 11.23.32 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 136, 3, 2, 'dubbing', '2020-12-19 04.22.12 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 137, 12, 2, 'subtitles', '2021-01-15 11.48.18 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 138, 11, 2, 'dubbing', '2021-01-14 07.31.14 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 139, 16, 1, 'dubbing', '2020-11-30 07.49.36 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 140, 11, 2, 'dubbing', '2021-01-28 06.34.07 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 141, 14, 2, 'subtitles', '2021-05-27 09.33.51 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 142, 8, 1, 'dubbing', '2020-12-24 12.41.29 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 143, 5, 2, 'dubbing', '2021-05-06 12.16.57 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 144, 9, 1, 'dubbing', '2021-01-27 12.03.40 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 145, 6, 2, 'subtitles', '2021-06-21 05.45.27 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 146, 14, 2, 'dubbing', '2021-06-15 11.27.12 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 147, 16, 2, 'subtitles', '2020-09-09 09.14.38 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 148, 4, 2, 'subtitles', '2021-01-10 05.27.11 AM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 149, 5, 1, 'subtitles', '2021-02-11 08.55.53 PM');
INSERT INTO cinemadb.showtime( id, movie_id, technology_id, language, `datetime` ) VALUES ( 150, 14, 2, 'dubbing', '2021-06-09 11.13.33 PM');
