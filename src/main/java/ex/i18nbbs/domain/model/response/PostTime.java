package ex.i18nbbs.domain.model.response;

import java.time.LocalDateTime;

public class PostTime {
    LocalDateTime value;

    @Deprecated
    PostTime(){}

    public PostTime(LocalDateTime value) {
        this.value = value;
    }

    public LocalDateTime value() {
        return value;
    }

    @Override
    public String toString() {
        return "PostTime{" +
                "value=" + value +
                '}';
    }
}
