package ex.i18nbbs.domain.model.thread;

/**
 * 1ページに表示するレスポンス量
 */
public class ThreadSize {
    int value;

    private ThreadSize(){}

    private ThreadSize(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static ThreadSize small(){
        return new ThreadSize(20);
    }

    public static ThreadSize medium(){
        return new ThreadSize(50);
    }

    public static ThreadSize large(){
        return new ThreadSize(100);
    }

    @Override
    public String toString() {
        return "ThreadSize{" +
                "value=" + value +
                '}';
    }
}
