package ex.i18nbbs.domain.model.response;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import ex.i18nbbs.domain.model.response.compare.ResponseComparator;
import ex.i18nbbs.domain.model.response.compare.ResponseReverseComparator;

/**
 * レスポンスの塊
 */
public class Responses {
    List<@Valid Response> list = new ArrayList<>();

    public Responses(){}

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

    public String firstPostTimeWithYMDHMS(){
        return firstResponse().postTime.showWithYMDHMS();
    }

    public String latestPostTimeWithYMDHMS(){
        return lastResponse().postTime.showWithYMDHMS();
    }


    public String firstPostTimeWithYMD(){
        return firstResponse().postTime.showWithYMD();
    }

    public String latestPostTimeWithYMD(){
        return lastResponse().postTime.showWithYMD();
    }

    public List<Response> asList(){
        return list;
    }
}
