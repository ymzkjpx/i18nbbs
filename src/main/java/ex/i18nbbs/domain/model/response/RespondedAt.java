package ex.i18nbbs.domain.model.response;

import java.time.LocalDateTime;

/**
 * 返信の投稿時間
 */
public class RespondedAt {
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
