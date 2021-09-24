package ex.i18nbbs.domain.model.thread.title;

/**
 * スレタイ作成者の名前
 */
public class ThreadOwner {
    String value;

    @Deprecated
    ThreadOwner(){}

    ThreadOwner(String value) {
        this.value = value;
    }

    String value() {
        return value;
    }

    boolean exists(){
        return this.value != null;
    }

    @Override
    public String toString() {
        return "ThreadOwner{" +
                "value='" + value + '\'' +
                '}';
    }
}
