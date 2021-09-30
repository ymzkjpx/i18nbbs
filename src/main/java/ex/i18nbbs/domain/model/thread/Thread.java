package ex.i18nbbs.domain.model.thread;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import ex.i18nbbs.domain.model.response.Response;
import ex.i18nbbs.domain.model.response.Responses;
import ex.i18nbbs.domain.model.thread.title.ThreadTheme;
import ex.i18nbbs.presentation.web.thread.viewmodel.ResponseRequest;

/**
 * スレッド
 */
public class Thread {
    @Valid
    ThreadNumber threadNumber;
    @Valid
    ResponsePerThread threadSize = ResponsePerThread.medium();
    @Valid
    ThreadTheme threadTheme;
    @Valid
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

    public String firstPostTimeWithYMDHMS(){
        return responses.firstPostTimeWithYMDHMS();
    }

    public String latestPostTimeWithYMDHMS(){
        return responses.latestPostTimeWithYMDHMS();
    }

    public String firstPostTimeWithYMD(){
        return responses.firstPostTimeWithYMD();
    }

    public String latestPostTimeWithYMD(){
        return responses.latestPostTimeWithYMD();
    }

}
