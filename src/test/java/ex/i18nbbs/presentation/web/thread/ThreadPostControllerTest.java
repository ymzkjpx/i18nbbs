package ex.i18nbbs.presentation.web.thread;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import ex.i18nbbs.i18nbbsTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@i18nbbsTest
@AutoConfigureMockMvc
class ThreadPostControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void 画面が表示できること() throws Exception {
        ResultActions result = mockMvc.perform(get("/thread/post"));
        result.andExpect(status().isOk());
    }

}