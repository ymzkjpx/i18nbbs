package ex.i18nbbs.domain.model.thread;

import javax.validation.constraints.NotNull;

/**
 * スレッド番号
 */
public class ThreadNumber {
    @NotNull
    int value;

    @Deprecated
    ThreadNumber(){}

    public ThreadNumber(int value) {
        this.value = value;
    }

    public ThreadNumber(String value){
        this.value = Integer.parseInt(value);
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
