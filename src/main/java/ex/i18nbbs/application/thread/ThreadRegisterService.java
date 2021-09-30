package ex.i18nbbs.application.thread;

import org.springframework.stereotype.Service;

import ex.i18nbbs.domain.model.response.Response;
import ex.i18nbbs.domain.model.thread.Thread;
import ex.i18nbbs.domain.model.thread.ThreadNumber;

/**
 * スレッド登録サービス
 */
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

    /**
     * スレッドに返信をする
     */
    public void newResponse(ThreadNumber threadNumber, Response response){
        threadRepository.newResponse(threadNumber, response);
    }
}

