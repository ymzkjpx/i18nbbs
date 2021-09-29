package ex.i18nbbs.presentation.web.thread.viewmodel;

import org.springframework.web.bind.annotation.RequestMapping;

import ex.i18nbbs.domain.model.response.ResponseOwner;
import ex.i18nbbs.domain.model.response.original.Original;
import ex.i18nbbs.domain.model.response.original.OriginalMessage;
import ex.i18nbbs.domain.model.thread.ThreadNumber;
import ex.i18nbbs.domain.model.thread.title.ThreadTheme;

public class ResponseRequest {
    ThreadNumber threadNumber;
    ThreadTheme threadTheme;
    ResponseOwner responseOwner;
    Original original;

    @Deprecated
    ResponseRequest(){}

    public ResponseRequest(ThreadNumber threadNumber, ThreadTheme threadTheme, ResponseOwner responseOwner, Original original) {
        this.threadNumber = threadNumber;
        this.threadTheme = threadTheme;
        this.responseOwner = responseOwner;
        this.original = original;
    }

    public static ResponseRequest empty(){
        return new ResponseRequest();
    }

    public ThreadNumber threadNumber() {
        return threadNumber;
    }

    public ThreadTheme threadTheme() {
        return threadTheme;
    }

    public ResponseOwner responseOwner() {
        return responseOwner;
    }

    public Original original() {
        return original;
    }
}
