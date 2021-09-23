package ex.i18nbbs.application.thread;

import org.springframework.stereotype.Service;

import ex.i18nbbs.domain.model.thread.Thread;
import ex.i18nbbs.domain.model.thread.ThreadNumber;

@Service
public class ThreadQueryService {
    ThreadRepository threadRepository;

    public ThreadQueryService(ThreadRepository threadRepository) {
        this.threadRepository = threadRepository;
    }

    public Thread findByThreadNumber(ThreadNumber threadNumber){
        return threadRepository.findByThreadNumber(threadNumber);
    }
}
