package com.it.cinemabackend.services;

import com.it.cinemabackend.model.movie.Showtime;
import com.it.cinemabackend.repository.ShowtimeRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.PropertyValueException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

@Service
public class ShowtimeService {

    Logger log = LoggerFactory.getLogger(this.getClass());

    private final ShowtimeRepository showtimeRepository;

    public ShowtimeService(ShowtimeRepository showtimeRepository) {
        this.showtimeRepository = showtimeRepository;
    }

    public Showtime save(Showtime showtime) {
        // TODO CONFIGURATE SHOWTIME CLASS TO MAKE THIS DEFAULT BEHAVIOUR
        if (showtime == null) {
            throw new InvalidDataAccessApiUsageException("Showtime can`t be null.");
        }
        if (showtime.getMovie() == null || showtime.getTechnology() == null) {
            throw new DataIntegrityViolationException("Property class is null.");
        }
        if (showtime.getMovie().isNew() || showtime.getTechnology().isNew()) {
            throw new PropertyValueException("Movie property does not exist in DB", "Showtime", "Movie");
        }
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
