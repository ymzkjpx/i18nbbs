package ex.i18nbbs.domain.model.response;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ex.i18nbbs.domain.model.response.compare.ResponseComparator;
import ex.i18nbbs.domain.model.response.compare.ResponseReverseComparator;

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

    private List<Response> unmodifiableCopy(){
        return new ArrayList<>(Collections.unmodifiableList(list));
    }

    public Response firstResponse(){
        List<Response> result = unmodifiableCopy();
        Collections.sort(result, new ResponseReverseComparator());
        return result.get(0);
    }

    public Response lastResponse(){
        List<Response> result = unmodifiableCopy();
        Collections.sort(result, new ResponseComparator());
        return result.get(0);
    }

    public int count(){
        return list.size();
    }

    public String firstPostTime(){
        return firstResponse().postTime.show();
    }

    public String latestPostTime(){
        return lastResponse().postTime.show();
    }


    public List<Response> asList(){
        return list;
    }
}
