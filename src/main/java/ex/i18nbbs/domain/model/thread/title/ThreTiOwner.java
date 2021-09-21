package ex.i18nbbs.domain.model.thread.title;

/**
 * スレタイ作成者の名前
 */
public class ThreTiOwner {
    String value;

    @Deprecated
    ThreTiOwner(){}

    ThreTiOwner(String value) {
        this.value = value;
    }

    String value() {
        return value;
    }

    @Override
    public String toString() {
        return "ThreTiOwner{" +
                "value='" + value + '\'' +
                '}';
    }
}
