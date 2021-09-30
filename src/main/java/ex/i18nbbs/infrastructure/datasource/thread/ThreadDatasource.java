package ex.i18nbbs.infrastructure.datasource.thread;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import ex.i18nbbs.application.thread.ThreadRepository;
import ex.i18nbbs.domain.model.response.Response;
import ex.i18nbbs.domain.model.thread.Thread;
import ex.i18nbbs.domain.model.thread.ThreadNumber;
import ex.i18nbbs.domain.model.thread.headline.Headline;
import ex.i18nbbs.domain.model.thread.headline.Headlines;

@Repository
public class ThreadDatasource implements ThreadRepository {

    ThreadMapper threadMapper;

    public ThreadDatasource(ThreadMapper threadMapper) {
        this.threadMapper = threadMapper;
    }

    @Override
    public Boolean existsThread(ThreadNumber threadNumber) {
        Thread result = threadMapper.findOne(threadNumber);
        return result != null;
    }

    @Override
    public Thread findByThreadNumber(ThreadNumber threadNumber) {
        Thread result = threadMapper.findThread(threadNumber);
        return result;
    }

    @Override
    public Headlines findHeadlines() {
        List<Headline> result = threadMapper.findHeadlines();
        if (result == null) return Headlines.empty();
        return Headlines.from(result);
    }

    @Override
    @Transactional
    public void newThread(Thread thread) {
        // TODO: 登録前のバリデーションを設ける.

        int nextThreadNumber = threadMapper.nextThreadNumber();
        threadMapper.insertThread(nextThreadNumber, thread);
        int nextThreadThemeNumber = threadMapper.nextThreadThemeNumber();
        threadMapper.insertThreadTheme(nextThreadThemeNumber, nextThreadNumber, thread.threadTheme());
        int nextResponseNumber = threadMapper.nextResponseNumber();
        threadMapper.insertResponse(nextResponseNumber, nextThreadNumber, 1, thread.responses().get(0));
        threadMapper.insertOriginalMessage(nextResponseNumber, thread.responses().get(0).original());
    }

    @Override
    @Transactional
    public void newResponse(ThreadNumber threadNumber, Response response) {
        // response番号の取得
        int nextResponseNumber = threadMapper.nextResponseNumber();
        // レスポンスorderの取得
        int nextResponseOrder = threadMapper.nextResponseOrder(threadNumber.value());
        // responseの登録
        threadMapper.insertResponse(nextResponseNumber, threadNumber.value(), nextResponseOrder, response);
        // originalMessageの登録
        threadMapper.insertOriginalMessage(nextResponseNumber, response.original());
    }
}
