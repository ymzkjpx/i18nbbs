package ex.i18nbbs.domain.model.response;

/**
 * 返信のID
 */
public class ResponseNumber {
    int value;

    @Deprecated
    ResponseNumber(){}

    public ResponseNumber(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ResponseNumber{" +
                "value='" + value + '\'' +
                '}';
    }
}
