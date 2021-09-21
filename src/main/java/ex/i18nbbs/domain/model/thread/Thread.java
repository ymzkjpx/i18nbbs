package ex.i18nbbs.domain.model.thread;

import ex.i18nbbs.domain.model.response.Responses;
import ex.i18nbbs.domain.model.thread.title.ThreTi;

/**
 * スレッド
 */
public class Thread {
    ThreadNumber threadNumber;
    ResponsePerThread threadSize = ResponsePerThread.medium();
    ThreTi threTi;
    Responses responses;

    @Deprecated
    Thread(){}

    public Thread(ThreTi threTi, Responses responses) {
        this.threTi = threTi;
        this.responses = responses;
    }

    public Thread(ResponsePerThread threadSize, ThreTi threTi, Responses responses) {
        this.threadSize = threadSize;
        this.threTi = threTi;
        this.responses = responses;
    }
}
