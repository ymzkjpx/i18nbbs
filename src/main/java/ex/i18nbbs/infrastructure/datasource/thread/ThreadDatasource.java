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
        // ThreadにThreadeNumberを登録する
        // ThreadThemeにThreadNumberとタイトルとユーザーを登録する
        // ResponseNumberを取得する
        // ResponseにThreadNumberとResponseNumberを登録する
        // OriginalMessageNumberを取得する
        // OriginalMessageにResponseNumberとOriginalMessageIdとOriginalMessageを登録する
        threadMapper.newThread(thread);
    }
}
