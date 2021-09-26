package ex.i18nbbs.domain.model.thread.headline;

import ex.i18nbbs.domain.model.response.Response;
import ex.i18nbbs.domain.model.thread.ThreadCreatedTime;
import ex.i18nbbs.domain.model.thread.ThreadNumber;
import ex.i18nbbs.domain.model.thread.title.ThreadTheme;

public class Headline {
    ThreadNumber threadNumber;
    ThreadTheme threadTheme;
    ThreadCreatedTime threadCreatedTime;
    Response firstResponse;

    public Headline(ThreadNumber threadNumber, ThreadTheme threadTheme, ThreadCreatedTime threadCreatedTime, Response firstResponse) {
        this.threadNumber = threadNumber;
        this.threadTheme = threadTheme;
        this.threadCreatedTime = threadCreatedTime;
        this.firstResponse = firstResponse;
    }

    public ThreadNumber threadNumber() {
        return threadNumber;
    }

    public ThreadTheme threadTheme() {
        return threadTheme;
    }

    public ThreadCreatedTime threadCreatedTime() {
        return threadCreatedTime;
    }

    public Response firstResponse() {
        return firstResponse;
    }

    @Override
    public String toString() {
        return "Headline{" +
                "threadNumber=" + threadNumber +
                ", threadTheme=" + threadTheme +
                ", threadCreatedTime=" + threadCreatedTime +
                ", firstResponse=" + firstResponse +
                '}';
    }
}
