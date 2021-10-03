package ex.i18nbbs.application.thread;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import ex.i18nbbs.domain.model.thread.Thread;
import ex.i18nbbs.domain.model.thread.ThreadNumber;
import ex.i18nbbs.domain.model.thread.headline.Headlines;
import ex.i18nbbs.i18nbbsTest;
import ex.i18nbbs.infrastructure.datasource.thread.ThreadMapper;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@i18nbbsTest
@AutoConfigureMockMvc
class ThreadQueryServiceTest {

    @Autowired
    ThreadQueryService threadQueryService;

    @Autowired
    ThreadMapper threadMapper;

    @Test
    public void スレッド見出しの一覧を取得する() {
        Headlines resultHeadline = threadQueryService.headlines();
        Thread actualThread = threadMapper.findThread(new ThreadNumber(1));
        assertAll(
                () -> assertEquals(resultHeadline.asList().get(0).threadNumber().value(), actualThread.threadNumber().value())
                , () -> assertEquals(resultHeadline.asList().get(0).response().responseNumber().value(), actualThread.responses().get(0).responseNumber().value())
        );
    }
}