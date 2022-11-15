package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RoomDaoTest {
/*    @Autowired
    private MockMvc mockMvc;*/

    @Autowired
    private RoomDao roomDao;

    @Test
    public void shouldFindARoomWithCorrectTemperature() throws Exception {
        Room room = roomDao.getOne(1L);
        Assertions.assertThat(room.getName()).isEqualTo("Room1");
        Assertions.assertThat(room.getCurrentTemperature()).isEqualTo(13.1);
    }

    @Test
    public void shouldFailOnFindARoomWithCorrectTemperature() throws Exception {
        Room room = roomDao.getOne(2L);
        Assertions.assertThat(room.getName()).isEqualTo("Room1");
        Assertions.assertThat(room.getCurrentTemperature()).isEqualTo(100000.0);
    }

    @Test
    public void shouldPassOnFindARoomLevelsCount() throws Exception {
        Room room = roomDao.getOne(2L);
        Assertions.assertThat(room.getFloor()).isEqualTo(2);
    }
    @Test
    public void shouldFailOnFindARoomLevelsCount() throws Exception {
        Room room = roomDao.getOne(2L);
        Assertions.assertThat(room.getFloor()).isEqualTo(20);
    }

    @Test
    public void shouldFailOnFindRoomNameById() throws Exception {
        Room room = roomDao.getOne(4L);
        Assertions.assertThat(room.getName()).isEqualTo("Room3");
    }

/*
    @Test
    @WithMockUser(username = "user", roles = "USER")
    void shouldDeleteBuilding() throws Exception {
        mockMvc.perform(delete("/api/building/1").accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().string(""));
    }*/
}
