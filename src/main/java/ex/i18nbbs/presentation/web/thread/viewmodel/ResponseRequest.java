package ex.i18nbbs.presentation.web.thread.viewmodel;

import ex.i18nbbs.domain.model.response.Response;
import ex.i18nbbs.domain.model.thread.ThreadNumber;

public class ResponseRequest {
    ThreadNumber threadNumber;
    Response response;

    @Deprecated
    ResponseRequest(){}

    public ResponseRequest(ThreadNumber threadNumber, Response response) {
        this.threadNumber = threadNumber;
        this.response = response;
    }

    public static ResponseRequest empty(){
        return new ResponseRequest();
    }

    public ThreadNumber threadNumber() {
        return threadNumber;
    }

    public Response response() {
        return response;
    }
}
