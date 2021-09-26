package ex.i18nbbs.application.thread;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import ex.i18nbbs.domain.model.thread.headline.Headlines;
import ex.i18nbbs.i18nbbsTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@i18nbbsTest
@AutoConfigureMockMvc
class ThreadQueryServiceTest {

    ThreadQueryService threadQueryService;

    public ThreadQueryServiceTest(ThreadQueryService threadQueryService) {
        this.threadQueryService = threadQueryService;
    }

    @Test
    public void スレッド見出しの一覧を取得する(){
        Headlines result = threadQueryService.headlines();
        System.out.println(result);
        assertEquals(result, 0);
    }
}