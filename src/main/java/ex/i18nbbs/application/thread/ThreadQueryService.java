package ex.i18nbbs.application.thread;

import org.springframework.stereotype.Service;

import ex.i18nbbs.domain.model.thread.Thread;
import ex.i18nbbs.domain.model.thread.ThreadNumber;
import ex.i18nbbs.domain.model.thread.headline.Headlines;

/**
 * スレッド検索サービス
 */
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
     * スレッド見出しの一覧を取得する
     */
    public Headlines headlines(){
        return threadRepository.findHeadlines();
    }

    /**
     * スレッドのやり取りを取得する.
     */
    public Thread findThreadByThreadNumber(ThreadNumber threadNumber){
        return threadRepository.findByThreadNumber(threadNumber);
    }
}
