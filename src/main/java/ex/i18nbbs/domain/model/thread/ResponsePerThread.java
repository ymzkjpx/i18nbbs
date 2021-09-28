package ex.i18nbbs.domain.model.thread;

import javax.validation.constraints.NotNull;

/**
 * 1ページ内に表示する返信数
 */
public class ResponsePerThread {
    @NotNull
    int value;

    private ResponsePerThread(){}

    private ResponsePerThread(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static ResponsePerThread small(){
        return new ResponsePerThread(20);
    }

    public static ResponsePerThread medium(){
        return new ResponsePerThread(50);
    }

    public static ResponsePerThread large(){
        return new ResponsePerThread(100);
    }

    @Override
    public String toString() {
        return "ResponsePerThread{" +
                "value=" + value +
                '}';
    }
}
