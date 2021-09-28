package ex.i18nbbs.domain.model.response;

import javax.validation.constraints.NotNull;

/**
 * 返信のID
 */
public class ResponseNumber {
    @NotNull
    int value;

    @Deprecated
    ResponseNumber(){}

    public ResponseNumber(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    @Override
    public String toString() {
        return "ResponseNumber{" +
                "value='" + value + '\'' +
                '}';
    }
}
