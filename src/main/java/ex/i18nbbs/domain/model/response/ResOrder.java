package ex.i18nbbs.domain.model.response;

/**
 * 1から始まるスレッド内の投稿順数
 */
public class ResOrder {
    int value;

    @Deprecated
    private ResOrder(){}

    private ResOrder(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static ResOrder first(){
        return new ResOrder(1);
    }

    @Override
    public String toString() {
        return "ResOrder{" +
                "value=" + value +
                '}';
    }
}
