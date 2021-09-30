package ex.i18nbbs.presentation.web.thread;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import ex.i18nbbs.application.thread.ThreadQueryService;
import ex.i18nbbs.domain.model.response.original.OriginalMessage;
import ex.i18nbbs.domain.model.thread.headline.Headlines;
import ex.i18nbbs.domain.model.thread.title.ThreadOwner;
import ex.i18nbbs.domain.model.thread.title.ThreadTitle;
import ex.i18nbbs.i18nbbsTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@i18nbbsTest
@AutoConfigureMockMvc
class ThreadPostControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ThreadQueryService threadQueryService;

    @Test
    void 画面が表示できること() throws Exception {
        ResultActions result = mockMvc.perform(get("/thread/post"));
        result.andExpect(status().isOk());
    }

    @Test
    void スレッドが建設できること() throws Exception{
        ThreadTitle dummyThreadTitle = new ThreadTitle("ダミースレッドタイトル");
        ThreadOwner dummyThreadOwner = new ThreadOwner("ダミーユーザー");
        OriginalMessage dummyOriginalMessage = new OriginalMessage("ダミースレッド1コメ目");

        ResultActions resultActions = mockMvc.perform(post("/thread/post")
                .param("threadTheme.threadTitle.value", dummyThreadTitle.value())
                .param("threadTheme.threadOwner.value", dummyThreadOwner.value())
                .param("responses.list[0].responseOwner.value", dummyThreadOwner.value())
                .param("responses.list[0].original.originalMessage.value", dummyOriginalMessage.value())
                .param("newThread", "新規スレッド作成")
        );
        Headlines headlines = threadQueryService.headlines();

        resultActions.andExpect(status().isFound());
        assertAll(()->assertEquals(dummyThreadTitle.value(), headlines.asList().get(headlines.asList().size()-1).threadTheme().threadTitle().value())
                , ()->assertEquals(dummyThreadOwner.value(), headlines.asList().get(headlines.asList().size()-1).threadTheme().threadOwner().value())
                , ()->assertEquals(dummyOriginalMessage.value(), headlines.asList().get(headlines.asList().size()-1).response().original().originalMessage().value())
        );
    }

}