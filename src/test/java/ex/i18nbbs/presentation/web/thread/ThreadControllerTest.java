package ex.i18nbbs.presentation.web.thread;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import ex.i18nbbs.application.thread.ThreadQueryService;
import ex.i18nbbs.domain.model.response.PostTime;
import ex.i18nbbs.domain.model.response.ResponseOwner;
import ex.i18nbbs.domain.model.response.original.OriginalMessage;
import ex.i18nbbs.domain.model.thread.Thread;
import ex.i18nbbs.domain.model.thread.ThreadNumber;
import ex.i18nbbs.i18nbbsTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@i18nbbsTest
@AutoConfigureMockMvc
class ThreadControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ThreadQueryService threadQueryService;

    @Test
    void 画面が表示できること() throws Exception {
        ResultActions result = mockMvc.perform(get("/thread/1"));
        result.andExpect(status().isOk());
    }

    @Test
    void 返信ができること() throws Exception {
        ResponseOwner dummyResponseOwner = new ResponseOwner("ダミーレスポンスオーナー");
        OriginalMessage dummyOriginalMessage = new OriginalMessage("ダミー返信本文");
        ThreadNumber dummyThreadNumber = new ThreadNumber(1);
        PostTime dummyPostTime = PostTime.now();

        ResultActions resultActions = mockMvc.perform(post(String.format("/thread/%s", String.valueOf(dummyThreadNumber.value())))
                .param("response.responseOwner.value", dummyResponseOwner.value())
                .param("response.original.originalMessage.value", dummyOriginalMessage.value())
                .param("threadNumber.value", String.valueOf(dummyThreadNumber.value()))
                .param("response.postTime.value", dummyPostTime.value().toString())
                .param("newResponse", "書き込む")
        );
        Thread result = threadQueryService.findThreadByThreadNumber(dummyThreadNumber);

        assertAll(
                () -> assertEquals(dummyThreadNumber.value(), result.threadNumber().value())
                , () -> assertEquals(dummyResponseOwner.value(), result.responses().get(result.responses().size() - 1).responseOwner().value())
                , () -> assertEquals(dummyPostTime.value(), result.responses().get(result.responses().size() - 1).postTime().value())
                , () -> assertEquals(dummyOriginalMessage.value(), result.responses().get(result.responses().size() - 1).original().originalMessage().value())
        );
        resultActions.andExpect(status().isFound());

    }

}