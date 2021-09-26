package ex.i18nbbs.domain.model.thread.headline;

import java.util.Collections;
import java.util.List;

public class Headlines {
    List<Headline> list;

    @Deprecated
    Headlines(){}

    private Headlines(List<Headline> list){
        this.list = list;
    }

    public static Headlines from(List<Headline> list){
        return new Headlines(list);
    }

    public static Headlines empty(){
        return new Headlines(Collections.emptyList());
    }

    public List<Headline> asList(){
        return list;
    }
}
