package ex.i18nbbs.domain.model.response.compare;

import java.util.Comparator;

import ex.i18nbbs.domain.model.response.Response;

public class ResponseComparator implements Comparator<Response> {

    @Override
    public int compare(Response o1, Response o2) {
        if(o1.postTime().value().isAfter(o2.postTime().value())) return -1;
        if(o1.postTime().value().isAfter(o2.postTime().value())) return 1;
        return 0;
    }
}
