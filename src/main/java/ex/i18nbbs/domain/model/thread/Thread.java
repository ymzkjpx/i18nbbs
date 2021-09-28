package ex.i18nbbs.domain.model.thread;

import java.util.List;

import ex.i18nbbs.domain.model.response.Response;
import ex.i18nbbs.domain.model.response.Responses;
import ex.i18nbbs.domain.model.thread.title.ThreadTheme;

/**
 * スレッド
 */
public class Thread {
    ThreadNumber threadNumber;
    ResponsePerThread threadSize = ResponsePerThread.medium();
    ThreadTheme threadTheme;
    Responses responses = new Responses();

    @Deprecated
    Thread(){}

    public Thread(ThreadNumber threadNumber, ThreadTheme threadTheme, Responses responses) {
        this.threadNumber = threadNumber;
        this.threadTheme = threadTheme;
        this.responses = responses;
    }

    public Thread(ThreadNumber threadNumber, ResponsePerThread threadSize, ThreadTheme threadTheme, Responses responses) {
        this.threadNumber = threadNumber;
        this.threadSize = threadSize;
        this.threadTheme = threadTheme;
        this.responses = responses;
    }

    public ThreadNumber threadNumber() {
        return threadNumber;
    }

    public ResponsePerThread threadSize() {
        return threadSize;
    }

    public ThreadTheme threadTheme() {
        return threadTheme;
    }

    public List<Response> responses(){
        return responses.asList();
    }
}
