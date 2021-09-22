package ex.i18nbbs.infrastructure.thread;

import org.springframework.stereotype.Repository;

import java.util.List;

import ex.i18nbbs.application.thread.ThreadRepository;
import ex.i18nbbs.domain.model.response.Response;
import ex.i18nbbs.domain.model.response.Responses;
import ex.i18nbbs.domain.model.thread.Thread;
import ex.i18nbbs.domain.model.thread.ThreadNumber;
import ex.i18nbbs.domain.model.thread.title.ThreTi;

@Repository
public class ThreadDatasource implements ThreadRepository {

    ThreadMapper threadMapper;

    public ThreadDatasource(ThreadMapper threadMapper) {
        this.threadMapper = threadMapper;
    }

    @Override
    public Thread findByThreadNumber(ThreadNumber threadNumber) {
        // ThreadNumberからList<Response>を取得
        List<Response> responsesList = threadMapper.findResponseList(threadNumber);
        Responses responses = new Responses(responsesList);
        ThreTi threTi = threadMapper.findThreTi(threadNumber);
        return new Thread(threTi, responses);
    }
}
