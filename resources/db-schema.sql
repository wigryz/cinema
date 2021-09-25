CREATE DATABASE cinemadb;

USE cinemadb;

CREATE TABLE genre ( 
	id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	name                 char(20)  NOT NULL    ,
	CONSTRAINT unq_genre UNIQUE ( name ) 
 );

CREATE TABLE movie ( 
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

CREATE TABLE movie_genre ( 
	movie_id             int  NOT NULL    ,
	genre_id             int  NOT NULL    ,
	CONSTRAINT pk_movie_genre PRIMARY KEY ( movie_id, genre_id )
 );

CREATE TABLE person ( 
	id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	first_name           char(20)  NOT NULL    ,
	second_name          char(20)      ,
	last_name            char(20)  NOT NULL    ,
	portrait_path        char(100)      
 );

CREATE TABLE technology ( 
	id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	name                 char(2)  NOT NULL    ,
	CONSTRAINT unq_technology UNIQUE ( name ) 
 );

CREATE TABLE movie_actor ( 
	movie_id             int  NOT NULL    ,
	person_id            int  NOT NULL    ,
	CONSTRAINT pk_movie_actor PRIMARY KEY ( movie_id, person_id )
 );

CREATE TABLE movie_director ( 
	movie_id             int  NOT NULL    ,
	person_id            int  NOT NULL    ,
	CONSTRAINT pk_movie_director PRIMARY KEY ( movie_id, person_id )
 );

CREATE TABLE showtime ( 
	id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	movie_id             int  NOT NULL    ,
	technology_id        int  NOT NULL    ,
	language             enum('dubbing','subtitles')      ,
	`datetime`           datetime  NOT NULL    
 );

CREATE INDEX fk_showtime_movie ON showtime ( movie_id );

CREATE INDEX fk_showtime_technology ON showtime ( technology_id );

ALTER TABLE movie_actor ADD CONSTRAINT fk_movie_actor_person FOREIGN KEY ( person_id ) REFERENCES person( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE movie_actor ADD CONSTRAINT fk_movie_actor_movie FOREIGN KEY ( movie_id ) REFERENCES movie( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE movie_director ADD CONSTRAINT fk_director_movie_person FOREIGN KEY ( person_id ) REFERENCES person( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE movie_director ADD CONSTRAINT fk_director_movie_movie FOREIGN KEY ( movie_id ) REFERENCES movie( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE movie_genre ADD CONSTRAINT fk_movie_category_category FOREIGN KEY ( genre_id ) REFERENCES genre( id ) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE movie_genre ADD CONSTRAINT fk_movie_category_movie FOREIGN KEY ( movie_id ) REFERENCES movie( id ) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE showtime ADD CONSTRAINT fk_showtime_movie FOREIGN KEY ( movie_id ) REFERENCES movie( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE showtime ADD CONSTRAINT fk_showtime_technology FOREIGN KEY ( technology_id ) REFERENCES technology( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

