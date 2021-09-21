package ex.i18nbbs.domain.model.thread;

/**
 * スレッド番号
 */
public class ThreadNumber {
    int value;

    @Deprecated
    ThreadNumber(){}

    public ThreadNumber(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    @Override
    public String toString() {
        return "ThreadNumber{" +
                "value=" + value +
                '}';
    }
}
