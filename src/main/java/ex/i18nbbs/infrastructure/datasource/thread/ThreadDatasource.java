package ex.i18nbbs.infrastructure.datasource.thread;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import ex.i18nbbs.application.thread.ThreadRepository;
import ex.i18nbbs.domain.model.response.Response;
import ex.i18nbbs.domain.model.response.ResponseNumber;
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
        // TODO: MyBatisに渡す値は可能な限りオブジェクトに固定し、プリミティブな形は控える. その上で尚プリミティブを採用する場合は、メソッドがプリミティブを要求していることをメソッドに説明させる.
        // TODO: int型をやめる.

        int nextThreadNumber = threadMapper.nextThreadNumber();
        threadMapper.insertThread(nextThreadNumber, thread);
        int nextThreadThemeNumber = threadMapper.nextThreadThemeNumber();
        threadMapper.insertThreadTheme(nextThreadThemeNumber, nextThreadNumber, thread.threadTheme());
        ResponseNumber nextResponseNumber = thread.responses().get(0).responseNumber();
        threadMapper.insertResponse(nextResponseNumber, nextThreadNumber, thread.responses().get(0));
        threadMapper.insertOriginalMessage(nextResponseNumber, thread.responses().get(0).original());
    }

    @Override
    @Transactional
    public void newResponse(ThreadNumber threadNumber, Response response) {
        ResponseNumber nextResponseNumber = response.responseNumber();
        threadMapper.insertResponse(nextResponseNumber, threadNumber.value(), response);
        threadMapper.insertOriginalMessage(nextResponseNumber, response.original());
    }
}
