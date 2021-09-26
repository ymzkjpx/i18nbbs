package ex.i18nbbs.application.thread;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import ex.i18nbbs.domain.model.thread.Thread;
import ex.i18nbbs.domain.model.thread.headline.Headlines;
import ex.i18nbbs.i18nbbsTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@i18nbbsTest
@AutoConfigureMockMvc
class ThreadQueryServiceTest {

    @Autowired
    ThreadQueryService threadQueryService;

    @Test
    public void スレッド見出しの一覧を取得する() {
        Headlines result = threadQueryService.headlines();
        assertAll(
                () -> assertEquals(result.asList().get(0).threadNumber().value(), 1)
                , () -> assertEquals(result.asList().get(0).response().responseNumber().value(), 1)
        );
    }
}