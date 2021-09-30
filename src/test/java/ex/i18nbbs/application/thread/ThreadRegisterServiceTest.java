package ex.i18nbbs.application.thread;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import java.time.LocalDateTime;
import java.util.Arrays;

import ex.i18nbbs.domain.model.response.PostTime;
import ex.i18nbbs.domain.model.response.Response;
import ex.i18nbbs.domain.model.response.ResponseNumber;
import ex.i18nbbs.domain.model.response.ResponseOwner;
import ex.i18nbbs.domain.model.response.Responses;
import ex.i18nbbs.domain.model.response.original.Original;
import ex.i18nbbs.domain.model.response.original.OriginalMessage;
import ex.i18nbbs.domain.model.response.original.OriginalNumber;
import ex.i18nbbs.domain.model.thread.Thread;
import ex.i18nbbs.domain.model.thread.ThreadNumber;
import ex.i18nbbs.domain.model.thread.title.ThreadOwner;
import ex.i18nbbs.domain.model.thread.title.ThreadTheme;
import ex.i18nbbs.domain.model.thread.title.ThreadTitle;
import ex.i18nbbs.i18nbbsTest;
import ex.i18nbbs.infrastructure.datasource.thread.ThreadMapper;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@i18nbbsTest
@AutoConfigureMockMvc
class ThreadRegisterServiceTest {

    @Autowired
    ThreadQueryService threadQueryService;

    @Autowired
    ThreadRegisterService threadRegisterService;

    @Autowired
    ThreadMapper threadMapper;

    @Test
    public void 新規スレッドを建設できること() {
        String dummyThreadTitle = "今日の夕食はカレーにしようと思うんだが…";
        String dummyThreadOwner = "北風小太郎";
        String dummyOriginalMessage = "" +
                "別にカレーが好きなわけでなかった。それは現在もだ。" +
                "でも今晩はカレーを食べなくてはならない気がしている。義務感でも、" +
                "責務でもなく、それでもどうしても今晩は…。" +
                "ちょっとこの訳をみんなに聞いて聞いてほしいのだが、" +
                "そもそも需要ある？いや、無くても勝手に語らせてもらうよ。";
        ThreadNumber threadNumber = new ThreadNumber(threadMapper.nextThreadNumber());
        Thread thread = new Thread(
                new ThreadNumber(threadNumber.value()),
                new ThreadTheme(
                        new ThreadTitle(dummyThreadTitle),
                        new ThreadOwner(dummyThreadOwner)
                ),
                new Responses(
                        Arrays.asList(
                                new Response(
                                        new ResponseNumber(threadMapper.nextResponseNumber()),
                                        new ResponseOwner(dummyThreadOwner),
                                        new PostTime(LocalDateTime.now()),
                                        new Original(
                                                OriginalNumber.nextNumber(),
                                                new OriginalMessage(dummyOriginalMessage)
                                        )
                                )
                        )
                )
        );
        threadRegisterService.register(thread);
        Thread result = threadQueryService.findThreadByThreadNumber(threadNumber);
        System.out.println(result);
        assertAll(
                () -> assertEquals(dummyThreadTitle, result.threadTheme().threadTitle().value())
                , () -> assertEquals(dummyThreadOwner, result.responses().get(0).responseOwner().value())
                , () -> assertEquals(dummyOriginalMessage, result.responses().get(0).original().originalMessage().value())
        );
    }
}