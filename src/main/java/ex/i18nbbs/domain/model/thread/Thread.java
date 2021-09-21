package ex.i18nbbs.domain.model.thread;

import java.util.ArrayList;
import java.util.List;

import ex.i18nbbs.domain.model.response.Response;
import ex.i18nbbs.domain.model.thread.title.ThreTi;

/**
 * スレッド
 */
public class Thread {
    ThreadSize threadSize = ThreadSize.medium();
    ThreTi threTi;
    List<Response> list = new ArrayList<>();

    @Deprecated
    Thread(){}

    public Thread(ThreTi threTi, List<Response> list) {
        this.threTi = threTi;
        this.list = list;
    }

    public Thread(ThreadSize threadSize, ThreTi threTi, List<Response> list) {
        this.threadSize = threadSize;
        this.threTi = threTi;
        this.list = list;
    }
}
