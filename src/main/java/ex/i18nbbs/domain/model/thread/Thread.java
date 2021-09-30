package ex.i18nbbs.domain.model.thread;

import java.util.List;

import javax.validation.Valid;

import ex.i18nbbs.domain.model.response.Response;
import ex.i18nbbs.domain.model.response.Responses;
import ex.i18nbbs.domain.model.thread.title.ThreadTheme;

/**
 * スレッド
 */
public class Thread {
    @Valid
    ThreadNumber threadNumber;
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

    public ThreadNumber threadNumber() {
        return threadNumber;
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

    @Override
    public String toString() {
        return "Thread{" +
                "threadNumber=" + threadNumber +
                ", threadTheme=" + threadTheme +
                ", responses=" + responses +
                '}';
    }
}
