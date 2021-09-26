package ex.i18nbbs.domain.model.thread.title;

import java.util.Collections;
import java.util.List;

public class ThreadTitles {
    List<ThreadTitle> list;

    @Deprecated
    ThreadTitles(){}

    private ThreadTitles(List<ThreadTitle> list) {
        this.list = list;
    }

    public static ThreadTitles from(List<ThreadTitle> list){
        return new ThreadTitles(list);
    }

    public static ThreadTitles empty(){
        return new ThreadTitles(Collections.emptyList());
    }

    public List<ThreadTitle> asList(){
        return list;
    }
}
