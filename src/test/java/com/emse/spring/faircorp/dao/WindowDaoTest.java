package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)*/
@ExtendWith(SpringExtension.class)
@DataJpaTest
class WindowDaoTest {
    @Autowired
    private WindowDao windowDao;
/*    @Autowired
    private MockMvc mockMvc;*/

    @Test
    public void shouldFindAWindow() {
        Window window = windowDao.getOne(1L);
        Assertions.assertThat(window.getName()).isEqualTo("window1");
        Assertions.assertThat(window.getWindowStatus()).isEqualTo(WindowStatus.CLOSED);
    }

    @Test
    public void shouldNotFindRoomOpenWindows() {
        List<Window> result = windowDao.findRoomOpenWindows(10L);
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    public void shouldFindRoomClosedWindow() {
        List<Window> result = windowDao.findRoomWindows(9L);
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    public void shouldFindRoomOpenWindows() {
        List<Window> result = windowDao.findRoomOpenWindows(1L);
        Assertions.assertThat(result)
                .hasSize(1)
                .extracting("id", "WindowStatus")
                .containsExactly(Tuple.tuple(2L, WindowStatus.OPEN));
    }
    @Test
    public void shouldFindRoomClosedWindows() {
        List<Window> result = windowDao.findRoomOpenWindows(3L);
        Assertions.assertThat(result)
                .hasSize(1)
                .extracting("id", "WindowStatus")
                .containsExactly(Tuple.tuple(2L, WindowStatus.OPEN));
    }
}
