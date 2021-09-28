package ex.i18nbbs.domain.model.response;

import javax.validation.constraints.NotNull;

public class ResponseOwner {
    @NotNull
    String value;

    @Deprecated
    ResponseOwner(){}

    public ResponseOwner(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return "ResponseOwner{" +
                "value='" + value + '\'' +
                '}';
    }
}
