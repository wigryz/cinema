package com.it.cinemabackend.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.it.cinemabackend.domain.dto.ShowtimeDTO;
import com.it.cinemabackend.domain.dto.ShowtimeNewDTO;
import com.it.cinemabackend.domain.mapper.ModelMapper;
import com.it.cinemabackend.domain.model.Language;
import com.it.cinemabackend.domain.model.Showtime;
import com.it.cinemabackend.service.ShowtimeService;
import com.it.cinemabackend.service.TechnologyService;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class ShowtimeControllerTest {

    @Mock
    ShowtimeService showtimeService;
    @Mock
    TechnologyService technologyService;
    @Mock
    ModelMapper modelMapper;

    MockMvc mockMvc;

    ShowtimeController showtimeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        showtimeController = new ShowtimeController(showtimeService, technologyService, modelMapper);
        mockMvc = MockMvcBuilders.standaloneSetup(showtimeController).build();
    }

    @Test
    void getCurrentShowtimes() throws Exception {
        LocalDateTime dateTime = LocalDateTime.of(2000, 4, 27, 12, 0);
        Showtime showtime = new Showtime();
        showtime.setDateTime(dateTime);
        ShowtimeDTO showtimeDTO = new ShowtimeDTO();
        showtimeDTO.setDateTime(dateTime);
        when(showtimeService.findCurrent()).thenReturn(List.of(showtime));
        when(modelMapper.showtimeToShowtimeDTO(any(Showtime.class))).thenReturn(showtimeDTO);

        mockMvc.perform(get("/api/showtime/current"))
            .andExpect(status().isOk())
            .andExpect(content().json("[{'dateTime':[2000,4,27,12,0]}]"));

        verify(showtimeService, times(1)).findCurrent();
    }

    @Test
    void getShowtimesForTheDay() throws Exception {
        LocalDateTime dateTime = LocalDateTime.of(2000, 4, 27, 12, 0);
        Showtime showtime = new Showtime();
        showtime.setDateTime(dateTime);
        ShowtimeDTO showtimeDTO = new ShowtimeDTO();
        showtimeDTO.setDateTime(dateTime);
        when(showtimeService.findByDate(dateTime.toLocalDate())).thenReturn(List.of(showtime));
        when(modelMapper.showtimeToShowtimeDTO(any(Showtime.class))).thenReturn(showtimeDTO);

        mockMvc.perform(get(String.format("/api/showtime/of-date/%s",
                dateTime.toLocalDate().format(DateTimeFormatter.ISO_DATE))))
            .andExpect(status().isOk())
            .andExpect(content().json("[{'dateTime':[2000,4,27,12,0]}]"));

        verify(showtimeService, times(1)).findByDate(dateTime.toLocalDate());
    }

    @Test
    void addShowtime() throws Exception {
        String language = "dubbing";
        ShowtimeNewDTO showtimeNewDTO = new ShowtimeNewDTO();
        showtimeNewDTO.setLanguage(language);
        Showtime showtime = new Showtime();
        showtime.setLanguage(Language.DUBBING);

        when(showtimeService.save(any(Showtime.class))).thenReturn(showtime);
        when(modelMapper.showtimeNewDTOToShowtime(any(ShowtimeNewDTO.class)))
            .thenReturn(showtime);

        mockMvc.perform(post("/api/showtime")
                .contentType(APPLICATION_JSON_UTF8)
                .content(convertObjectToJsonBytes(showtimeNewDTO)))
            .andDo(print())
            .andExpect(status().isOk());

        verify(showtimeService, times(1)).save(any(Showtime.class));
    }

    public static final MediaType APPLICATION_JSON_UTF8 =
        new MediaType(MediaType.APPLICATION_JSON.getType(),
                      MediaType.APPLICATION_JSON.getSubtype(),
                      StandardCharsets.UTF_8);

    public static byte[] convertObjectToJsonBytes(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }
}
