package ex.i18nbbs.application.thread;

import ex.i18nbbs.domain.model.thread.Thread;
import org.springframework.stereotype.Service;

@Service
public class ThreadRegisterService {
    ThreadRepository threadRepository;

    public ThreadRegisterService(ThreadRepository threadRepository) {
        this.threadRepository = threadRepository;
    }

    /**
     * スレッドを新規作成する
     */
    public void register(Thread thread){
        threadRepository.newThread(thread);
    }
}
