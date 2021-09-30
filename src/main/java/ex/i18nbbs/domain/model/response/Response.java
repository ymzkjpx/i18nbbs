package ex.i18nbbs.domain.model.response;

import javax.validation.Valid;

import ex.i18nbbs.domain.model.response.original.Original;

/**
 * 返信
 */
public class Response {
    @Valid
    ResponseNumber responseNumber;
    @Valid
    ResponseOwner responseOwner;
    @Valid
    PostTime postTime = PostTime.now();
    @Valid
    Original original = new Original();

    @Deprecated
    Response(){}

    public Response(ResponseNumber responseNumber, ResponseOwner responseOwner, PostTime postTime, Original original) {
        this.responseNumber = responseNumber;
        this.responseOwner = responseOwner;
        this.postTime = postTime;
        this.original = original;
    }

    public static Response empty(){
        return new Response();
    }

    public ResponseNumber responseNumber() {
        return responseNumber;
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
                ", responseOwner=" + responseOwner +
                ", postTime=" + postTime +
                ", original=" + original +
                '}';
    }
}
