package ex.i18nbbs.domain.model.thread.title;

/**
 * 1コメのタイトル
 */
public class ThreadTitle {
    String value;
    @Deprecated
    ThreadTitle(){}

    public ThreadTitle(String value) {
        this.value = value;
    }

    public String show() {
        return toString();
    }

    @Override
    public String toString() {
        return value;
    }
}
