package ex.i18nbbs.domain.model.thread;

import ex.i18nbbs.domain.model.response.Responses;
import ex.i18nbbs.domain.model.thread.title.ThreadTitle;

/**
 * スレッド
 */
public class Thread {
    ThreadNumber threadNumber;
    ResponsePerThread threadSize = ResponsePerThread.medium();
    ThreadTitle threadTitle;
    Responses responses;

    @Deprecated
    Thread(){}

    public Thread(ThreadNumber threadNumber, ThreadTitle threadTitle, Responses responses) {
        this.threadNumber = threadNumber;
        this.threadTitle = threadTitle;
        this.responses = responses;
    }

    public Thread(ThreadTitle threadTitle, Responses responses) {
        this.threadTitle = threadTitle;
        this.responses = responses;
    }

    public Thread(ResponsePerThread threadSize, ThreadTitle threadTitle, Responses responses) {
        this.threadSize = threadSize;
        this.threadTitle = threadTitle;
        this.responses = responses;
    }
}
