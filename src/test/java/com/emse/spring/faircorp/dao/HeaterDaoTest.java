package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.api.BuildingController;
import com.emse.spring.faircorp.api.HeaterController;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;
import org.assertj.core.api.Assertions;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@ExtendWith(SpringExtension.class)
@DataJpaTest
class HeaterDaoTest {
    @Autowired
    private HeaterDao heaterDao;



    /** No matter how hard I tried MockMvc service kept failing*/
    /* @Autowired
    private MockMvc mockMvc;*/



    @Test
    public void shouldFindAnOnHeaterByID() {
        Heater heater = heaterDao.getOne(1L);
        Assertions.assertThat(heater.getName()).isEqualTo("Heater1");
        Assertions.assertThat(heater.getHeaterStatus()).isEqualTo(HeaterStatus.ON);
    }

    @Test
    public void shouldFindAnOffHeaterByID() {
        Heater heater = heaterDao.getOne(1L);
        Assertions.assertThat(heater.getName()).isEqualTo("Heater2");
        Assertions.assertThat(heater.getHeaterStatus()).isEqualTo(HeaterStatus.OFF);
    }
    @Test
    public void shouldNoFindAHeaterByID() {
        Heater heater = heaterDao.getOne(1L);
        Assertions.assertThat(heater.getName()).isEqualTo("Heater10");
        Assertions.assertThat(heater.getHeaterStatus()).isEqualTo(HeaterStatus.OFF);
    }
    @Test
    public void shouldFailOnFindAHeaterByID() {
        Heater heater = heaterDao.getOne(1L);
        Assertions.assertThat(heater.getName()).isEqualTo("Heater2");
        Assertions.assertThat(heater.getHeaterStatus()).isEqualTo(HeaterStatus.OFF);
    }


/*    @Test
    @WithMockUser(username = "user", roles = "PEASANT")
    void shouldLoadAHeaterAndReturnNull() throws Exception {
        mockMvc.perform(get("/api/heaters/69").accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    @WithMockUser(username = "user", roles = "PEASANT")
    void shouldDeleteHeater() throws Exception {
        mockMvc.perform(delete("/api/heaters/20").accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    @WithMockUser(username = "user", roles = "PEASANT")
    void shouldLoadAHeaterAndReturnValue() throws Exception {
        mockMvc.perform(get("/api/heaters/69").accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Heater1"));
    }*/
}
