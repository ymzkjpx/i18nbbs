package ex.i18nbbs.domain.model.thread.title;

/**
 * 1コメのタイトル
 */
public class ThreadFirstComment {
    String value;
    @Deprecated
    ThreadFirstComment(){}

    public ThreadFirstComment(String value) {
        this.value = value;
    }

    public String show() {
        return toString();
    }

    boolean exists(){
        return this.value != null;
    }


    @Override
    public String toString() {
        return value;
    }
}
