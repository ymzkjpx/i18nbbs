package ex.i18nbbs.domain.model.response;

import ex.i18nbbs.domain.model.response.original.Original;

/**
 * 返信
 */
public class Response {
    ResponseNumber responseNumber = ResponseNumber.nextNumber();
    Original original;

    @Deprecated
    Response(){}

    public Response(ResponseNumber responseNumber, Original original) {
        this.responseNumber = responseNumber;
        this.original = original;
    }

    public ResponseNumber responseNumber() {
        return responseNumber;
    }

    public Original original() {
        return original;
    }

    public Response refreshOriginalNumber(Response other){
        Original originalResult = Original.refreshNumber(other.original);
        return new Response(this.responseNumber, originalResult);
    }

    public Response refreshResponseNumber(Response other){
        ResponseNumber responseNumberResult = ResponseNumber.nextNumber();
        return new Response(responseNumberResult, this.original);
    }

    @Override
    public String toString() {
        return "Response{" +
                "responseNumber=" + responseNumber +
                ", original=" + original +
                '}';
    }
}
