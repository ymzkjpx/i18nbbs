package ex.i18nbbs.domain.model.response;

import ex.i18nbbs.domain.model.response.original.Original;

/**
 * 返信
 */
public class Response {
    ResponseNumber responseNumber;
    ResOrder resOrder;
    Original original;

    @Deprecated
    Response(){}

    public Response(ResponseNumber responseNumber, ResOrder resOrder, Original original) {
        this.responseNumber = responseNumber;
        this.resOrder = resOrder;
        this.original = original;
    }

    public ResponseNumber responseNumber() {
        return responseNumber;
    }

    public ResOrder resOrder() {
        return resOrder;
    }

    public Original original() {
        return original;
    }

    public Response refreshOriginalNumber(Response other){
        Original originalResult = Original.refreshNumber(other.original);
        return new Response(this.responseNumber, this.resOrder, originalResult);
    }

    @Override
    public String toString() {
        return "Response{" +
                "responseNumber=" + responseNumber +
                ", original=" + original +
                '}';
    }
}
