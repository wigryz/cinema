/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
INSERT INTO `genre` (id, name) VALUES (1,'Genre1'),(2,'Genre2'),(3,'Genre3'),(4,'Genre4'),(5,'Genre');
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;

/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` (id, title, short_description, description, year_of_production, duration, age_restriction, poster_path) VALUES (1,'Movie1','Short description1','Description1',2001,50,5,'resources/posters/poster1.jpg'),(2,'Movie2','Short description2','Description2',2002,60,13,'resources/posters/poster2.jpg'),(3,'Movie3','Short description3','Description3',2003,70,15,'resources/posters/poster3.jpg'),(4,'Movie4','Short description4','Description4',2004,80,18,'resources/posters/poster4.jpg'),(5,'Movie5','Short description5','Description5',2005,90,21,'resources/posters/poster5.jpg');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;

/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` (id, first_name, second_name, last_name, portrait_path) VALUES (1,'FirstName1',NULL,'LastName1','resources/portraits/portrait1.jpg'),(2,'FirstName2','SecondName2','LastName2','resources/portraits/portrait2.jpg'),(3,'FirstName3','SecondName3','LastName3','resources/portraits/portrait3.jpg'),(4,'FirstName4',NULL,'LastName4','resources/portraits/portrait4.jpg'),(5,'FirstName5',NULL,'LastName5','resources/portraits/portrait5.jpg');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;

/*!40000 ALTER TABLE `technology` DISABLE KEYS */;
INSERT INTO `technology` (id, name) VALUES (1,'2D'),(2,'3D');
/*!40000 ALTER TABLE `technology` ENABLE KEYS */;

/*!40000 ALTER TABLE `movie_actor` DISABLE KEYS */;
INSERT INTO `movie_actor` (movie_id, person_id) VALUES (1,1),(1,2),(2,2),(2,3),(3,3),(3,4),(3,5),(5,1),(5,2),(5,3);
/*!40000 ALTER TABLE `movie_actor` ENABLE KEYS */;

/*!40000 ALTER TABLE `movie_director` DISABLE KEYS */;
INSERT INTO `movie_director` (movie_id, person_id) VALUES (1,5),(2,1),(3,1),(4,1),(4,2);
/*!40000 ALTER TABLE `movie_director` ENABLE KEYS */;

/*!40000 ALTER TABLE `movie_genre` DISABLE KEYS */;
INSERT INTO `movie_genre` (movie_id, genre_id) VALUES (1,1),(1,2),(2,1),(2,3),(3,1),(3,2),(4,4),(5,5),(5,4),(5,3);
/*!40000 ALTER TABLE `movie_genre` ENABLE KEYS */;

/*!40000 ALTER TABLE `showtime` DISABLE KEYS */;
INSERT INTO `showtime` (id, movie_id, technology_id, language, datetime) VALUES (1,1,2,'DUBBING',now()),(2,2,1,'DUBBING',now() - INTERVAL 1 DAY),(3,3,2,'DUBBING',now() + INTERVAL 1 DAY),(4,4,1,'DUBBING','2021-06-23 19:00:00'),(5,5,1,'SUBTITLES','2021-08-02 04:00:00'),(6,1,2,'DUBBING','2020-11-19 09:00:00'),(7,2,2,'DUBBING','2021-05-06 22:00:00'),(8,3,1,'DUBBING','2020-12-13 17:00:00'),(9,4,2,'SUBTITLES','2020-09-29 12:00:00'),(10,5,2,'DUBBING','2021-03-01 19:35:00'),(11,1,2,'SUBTITLES','2020-09-09 23:30:00'),(12,1,1,'SUBTITLES','2021-07-09 02:00:00'),(13,1,1,'DUBBING','2021-05-14 03:30:00'),(14,1,2,'SUBTITLES','2021-06-19 15:30:00'),(15,1,1,'SUBTITLES','2021-06-21 17:30:00'),(16,1,2,'DUBBING',now() + INTERVAL 1 HOUR ),(17,1,2,'DUBBING',now() + INTERVAL 3 HOUR ),(18,1,2,'DUBBING',now() + INTERVAL 2 HOUR );
/*!40000 ALTER TABLE `showtime` ENABLE KEYS */;
