package ex.i18nbbs.domain.model.response;

import ex.i18nbbs.domain.model.response.original.Original;

/**
 * 返信
 */
public class Response {
    ResponseNumber responseNumber;
    ResponseOrder responseOrder;
    ResponseOwner responseOwner;
    PostTime postTime;
    Original original;

    @Deprecated
    Response(){}

    public Response(ResponseNumber responseNumber, ResponseOrder responseOrder, ResponseOwner responseOwner, PostTime postTime, Original original) {
        this.responseNumber = responseNumber;
        this.responseOrder = responseOrder;
        this.responseOwner = responseOwner;
        this.postTime = postTime;
        this.original = original;
    }

    public ResponseNumber responseNumber() {
        return responseNumber;
    }

    public ResponseOrder resOrder() {
        return responseOrder;
    }

    public ResponseOwner responseOwner() {
        return responseOwner;
    }

    public PostTime postTime() {
        return postTime;
    }

    public Original original() {
        return original;
    }

    @Override
    public String toString() {
        return "Response{" +
                "responseNumber=" + responseNumber +
                ", responseOrder=" + responseOrder +
                ", responseOwner=" + responseOwner +
                ", postTime=" + postTime +
                ", original=" + original +
                '}';
    }
}
