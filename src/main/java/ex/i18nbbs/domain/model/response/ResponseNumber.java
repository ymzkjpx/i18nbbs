package ex.i18nbbs.domain.model.response;

import java.util.UUID;

import javax.validation.constraints.NotNull;

/**
 * 返信のID
 */
public class ResponseNumber {
    @NotNull
    String value;

    @Deprecated
    ResponseNumber(){}

    public ResponseNumber(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static ResponseNumber generate(){
        return new ResponseNumber(UUID.randomUUID().toString());
    }

    @Override
    public String toString() {
        return "ResponseNumber{" +
                "value='" + value + '\'' +
                '}';
    }
}
