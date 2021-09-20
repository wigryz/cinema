CREATE TABLE category (
                          id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
                          name                 char(20)  NOT NULL
);

CREATE TABLE country (
                         id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
                         name                 char(30)  NOT NULL
);

CREATE TABLE hall (
                      id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
                      hall_mark            int  NOT NULL,
                      number_of_rows       int  NOT NULL,
                      number_of_columns    int
);

CREATE TABLE movie (
                       id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
                       title                char(100)  NOT NULL,
                       description          text,
                       year_of_production   int,
                       duration             int,
                       rating               double,
                       additional_info      char(50),
                       country_id           int
);

CREATE TABLE movie_category (
                                id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
                                movie_id             int  NOT NULL,
                                category_id          int  NOT NULL
);

CREATE TABLE principal_category (
                                    id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
                                    name                 char(20)  NOT NULL
);

CREATE TABLE seat_category (
                               id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
                               name                 char(20)  NOT NULL
);

CREATE TABLE showtime (
                          id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
                          movie_id             int  NOT NULL,
                          showtime_date        datetime  NOT NULL,
                          hall_id              int  NOT NULL
);

CREATE TABLE technology (
                            id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
                            name                 char(2)  NOT NULL
);

CREATE TABLE ticket (
                        id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
                        first_name           char(20)  NOT NULL,
                        last_name            char(20)  NOT NULL,
                        showtime_id          int  NOT NULL,
                        discount_type_id     int,
                        seat_column          int  NOT NULL,
                        seat_row             int  NOT NULL,
                        barcode              char(100),
                        seat_category_id     int  NOT NULL
);

CREATE TABLE movie_technology (
                                  id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
                                  movie_id             int  NOT NULL,
                                  tech_id              int  NOT NULL
);

CREATE TABLE principal (
                           id                   int NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
                           first_name           char(20)  NOT NULL,
                           second_name          char(20),
                           last_name            char(20)  NOT NULL,
                           sex                  enum('male', 'female'),
                           biography            text,
                           country_of_origin_id int,
                           category_id          int  NOT NULL
);

CREATE TABLE movie_principal (
                                 id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
                                 movie_id             int  NOT NULL,
                                 principal_id         int  NOT NULL
);

ALTER TABLE movie ADD CONSTRAINT fk_movie_country FOREIGN KEY ( country_id ) REFERENCES country( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE movie_category ADD CONSTRAINT fk_movie_category_movie FOREIGN KEY ( movie_id ) REFERENCES movie( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE movie_category ADD CONSTRAINT fk_movie_category_category FOREIGN KEY ( category_id ) REFERENCES category( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE movie_principal ADD CONSTRAINT fk_movie_principal_movie FOREIGN KEY ( movie_id ) REFERENCES movie( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE movie_principal ADD CONSTRAINT fk_movie_principal_principal FOREIGN KEY ( principal_id ) REFERENCES principal( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE movie_technology ADD CONSTRAINT fk_movie_technology_movie FOREIGN KEY ( movie_id ) REFERENCES movie( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE movie_technology ADD CONSTRAINT fk_movie_technology_technology FOREIGN KEY ( tech_id ) REFERENCES technology( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE principal ADD CONSTRAINT fk_principal_country FOREIGN KEY ( country_of_origin_id ) REFERENCES country( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE principal ADD CONSTRAINT fk_principal_category_d FOREIGN KEY ( category_id ) REFERENCES principal_category( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE showtime ADD CONSTRAINT fk_showtime_movie FOREIGN KEY ( movie_id ) REFERENCES movie( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE showtime ADD CONSTRAINT fk_showtime_hall FOREIGN KEY ( hall_id ) REFERENCES hall( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE ticket ADD CONSTRAINT fk_ticket_seat_category FOREIGN KEY ( seat_category_id ) REFERENCES seat_category( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE ticket ADD CONSTRAINT fk_ticket_showtime FOREIGN KEY ( showtime_id ) REFERENCES showtime( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;