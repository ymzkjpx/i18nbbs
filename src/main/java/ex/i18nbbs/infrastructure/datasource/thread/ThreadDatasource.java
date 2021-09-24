package ex.i18nbbs.infrastructure.datasource.thread;

import org.springframework.stereotype.Repository;

import ex.i18nbbs.application.thread.ThreadRepository;
import ex.i18nbbs.domain.model.thread.Thread;
import ex.i18nbbs.domain.model.thread.ThreadNumber;
import ex.i18nbbs.domain.model.thread.title.NumberOfThreadTitles;

@Repository
public class ThreadDatasource implements ThreadRepository {

    ThreadMapper threadMapper;

    public ThreadDatasource(ThreadMapper threadMapper) {
        this.threadMapper = threadMapper;
    }

    @Override
    public Boolean existsThread(ThreadNumber threadNumber) {
        NumberOfThreadTitles result = threadMapper.findOne(threadNumber);
        return result.exists();
    }

    @Override
    public Thread findByThreadNumber(ThreadNumber threadNumber) {
        Thread result = threadMapper.findThread(threadNumber);
        return result;
    }
}
