package ex.i18nbbs.infrastructure.datasource.thread;

import org.springframework.stereotype.Repository;

import ex.i18nbbs.application.thread.ThreadRepository;
import ex.i18nbbs.domain.model.thread.Thread;
import ex.i18nbbs.domain.model.thread.ThreadNumber;

@Repository
public class ThreadDatasource implements ThreadRepository {

    ThreadMapper threadMapper;

    public ThreadDatasource(ThreadMapper threadMapper) {
        this.threadMapper = threadMapper;
    }

    @Override
    public Thread findByThreadNumber(ThreadNumber threadNumber) {
        Thread result = threadMapper.findThread(threadNumber);
        return result;
//        List<Response> responsesList = threadMapper.findResponseList(threadNumber);
//        Responses responses = new Responses(responsesList);
//        ThreadTitle threadTitle = threadMapper.findThreadTitle(threadNumber);
//        return new Thread(threadTitle, responses);
    }
}
