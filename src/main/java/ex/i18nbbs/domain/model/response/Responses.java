package ex.i18nbbs.domain.model.response;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * レスポンスの塊
 */
public class Responses {
    List<Response> list;

    @Deprecated
    Responses(){}

    public Responses(List<Response> list) {
        this.list = list;
    }

    public static Responses empty(){
        return new Responses(Collections.emptyList());
    }

    public List<Response> asList(){
        return list;
    }
}
