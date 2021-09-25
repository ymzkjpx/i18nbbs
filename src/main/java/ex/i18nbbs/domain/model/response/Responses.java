package ex.i18nbbs.domain.model.response;

import java.time.LocalDateTime;
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

    // TODO: スレッド作成日時を得る.
    public LocalDateTime firstPostTime(){
        return null;
    }

    //todo: 最終レスポンス日時を得る.
    public LocalDateTime lastPostTime(){
        return null;
    }

    public int count(){
        return list.size();
    }

    public static Responses empty(){
        return new Responses(Collections.emptyList());
    }

    public List<Response> asList(){
        return list;
    }
}
