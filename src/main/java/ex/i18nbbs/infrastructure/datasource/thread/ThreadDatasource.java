package ex.i18nbbs.infrastructure.datasource.thread;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import ex.i18nbbs.application.thread.ThreadRepository;
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
        // ThreadNumberを取得する
        int nextThreadNumber = threadMapper.nextThreadNumber();
        // ThreadにThreadNumberを登録する
        threadMapper.insertThread(nextThreadNumber, thread);
        // ThreadThemeNumberを取得する
        int nextThreadThemeNumber = threadMapper.nextThreadThemeNumber();
        // ThreadThemeにThreadNumberとタイトルとユーザーを登録する
        threadMapper.insertThreadTheme(nextThreadThemeNumber, nextThreadNumber, thread.threadTheme());
        // ResponseNumberを取得する
        int nextResponseNumber = threadMapper.nextResponseNumber();
        // ResponseにThreadNumberとResponseNumberを登録する
        threadMapper.insertResponse(nextResponseNumber, nextThreadNumber, thread.threadTheme().threadOwner().value());
        // OriginalMessageにResponseNumberとOriginalMessageIdとOriginalMessageを登録する
        threadMapper.insertOriginal(thread.responses().get(0).original(), nextResponseNumber);
    }
}
