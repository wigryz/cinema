package com.it.cinemabackend.services;

import com.it.cinemabackend.model.movie.Showtime;
import com.it.cinemabackend.repository.ShowtimeRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ShowtimeService {

    Logger log = LoggerFactory.getLogger(this.getClass());

    private final ShowtimeRepository showtimeRepository;

    public ShowtimeService(ShowtimeRepository showtimeRepository) {
        this.showtimeRepository = showtimeRepository;
    }

    public Showtime save(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    public List<Showtime> findCurrent() {
        return findByDate(LocalDate.now());
    }

    public List<Showtime> findByDate(LocalDate date) {
        log.debug("Querying showtimes by date: {}", LocalDate.now());
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = startOfDay.plusDays(1);
        return showtimeRepository.findShowtimeByDateTimeBetween(startOfDay, endOfDay);
    }

    public List<Showtime> findAll() {
        List<Showtime> showtimes = new ArrayList<>();
        showtimeRepository.findAll().forEach(showtimes::add);
        return showtimes;
    }
}