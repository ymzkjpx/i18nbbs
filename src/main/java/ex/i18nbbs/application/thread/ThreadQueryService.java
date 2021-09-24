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

    /**
     * スレッドの実在を確認する
     */
    public Boolean existsThread(ThreadNumber threadNumber){
        return threadRepository.existsThread(threadNumber);
    }

    /**
     * スレッドのやり取りを取得する.
     */
    public Thread findByThreadNumber(ThreadNumber threadNumber){
        return threadRepository.findByThreadNumber(threadNumber);
    }
}
