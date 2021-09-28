package ex.i18nbbs.domain.model.response;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;

public class PostTime {
    @NotNull(message = "投稿日時が不正です")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDateTime value = LocalDateTime.now();

    @Deprecated
    PostTime(){}

    public PostTime(LocalDateTime value) {
        this.value = value;
    }

    public LocalDateTime value() {
        return value;
    }

    public static DateTimeFormatter formatterWithYMDHMS = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public String showWithYMDHMS(){
        return value.format(formatterWithYMDHMS);
    }

    public static DateTimeFormatter formatterWithYMD = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    public String showWithYMD(){
        return value.format(formatterWithYMD);
    }

    @Override
    public String toString() {
        return "PostTime{" +
                "value=" + value +
                '}';
    }
}
