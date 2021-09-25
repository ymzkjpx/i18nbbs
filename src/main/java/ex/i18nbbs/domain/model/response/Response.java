package ex.i18nbbs.domain.model.response;

import ex.i18nbbs.domain.model.response.original.Original;

/**
 * 返信
 */
public class Response {
    ResponseNumber responseNumber;
    ResponseOrder responseOrder;
    PostTime postTime;
    Original original;

    @Deprecated
    Response(){}

    public Response(ResponseNumber responseNumber, ResponseOrder responseOrder, Original original) {
        this.responseNumber = responseNumber;
        this.responseOrder = responseOrder;
        this.original = original;
    }

    public ResponseNumber responseNumber() {
        return responseNumber;
    }

    public ResponseOrder resOrder() {
        return responseOrder;
    }

    public Original original() {
        return original;
    }

    public PostTime postTime() {
        return postTime;
    }

    public Response refreshOriginalNumber(Response other){
        Original originalResult = Original.refreshNumber(other.original);
        return new Response(this.responseNumber, this.responseOrder, originalResult);
    }

    @Override
    public String toString() {
        return "Response{" +
                "responseNumber=" + responseNumber +
                ", original=" + original +
                '}';
    }
}
