package ex.i18nbbs.domain.model.response;

/**
 * 1から始まるスレッド内の投稿順数
 */
public class ResponseOrder {
    int value;

    @Deprecated
    private ResponseOrder(){}

    private ResponseOrder(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static ResponseOrder first(){
        return new ResponseOrder(1);
    }

    @Override
    public String toString() {
        return "ResOrder{" +
                "value=" + value +
                '}';
    }
}