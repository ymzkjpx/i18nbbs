package ex.i18nbbs.domain.model.thread.title;

/**
 * スレタイ作成者の名前
 */
public class ThreadTitleOwner {
    String value;

    @Deprecated
    ThreadTitleOwner(){}

    ThreadTitleOwner(String value) {
        this.value = value;
    }

    String value() {
        return value;
    }

    @Override
    public String toString() {
        return "ThreadTitleOwner{" +
                "value='" + value + '\'' +
                '}';
    }
}
