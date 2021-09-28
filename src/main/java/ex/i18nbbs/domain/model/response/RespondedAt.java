package ex.i18nbbs.domain.model.response;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

/**
 * 返信の投稿時間
 */
public class RespondedAt {
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    LocalDateTime value;

    @Deprecated
    RespondedAt(){}

    public RespondedAt(LocalDateTime value) {
        this.value = value;
    }

    public static RespondedAt from(LocalDateTime localDateTime){
        return new RespondedAt(localDateTime);
    }

    @Override
    public String toString() {
        return "RespondedAt{" +
                "value=" + value +
                '}';
    }
}
