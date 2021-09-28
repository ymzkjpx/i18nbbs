package ex.i18nbbs.domain.model.thread;

import javax.validation.constraints.NotNull;

/**
 * スレタイ作成者の名前
 */
public class ThreadOwner {
    @NotNull
    String value;

    @Deprecated
    ThreadOwner(){}

    public ThreadOwner(String value) {
        this.value = value;
    }

    public String value() {
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
