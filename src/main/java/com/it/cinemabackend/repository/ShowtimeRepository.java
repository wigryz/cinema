package com.it.cinemabackend.repository;

import com.it.cinemabackend.model.movie.Showtime;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowtimeRepository extends CrudRepository<Showtime, Long> {

    List<Showtime> findShowtimeByDateTimeBetween(LocalDateTime dateTime, LocalDateTime dateTime2);
}