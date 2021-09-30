package ex.i18nbbs.domain.model.thread;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;

/**
 * スレッド建設日時
 */
public class ThreadCreatedTime {
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    LocalDateTime value;

    @Deprecated
    ThreadCreatedTime() {
    }

    public ThreadCreatedTime(LocalDateTime value) {
        this.value = value;
    }

    public LocalDateTime value() {
        return value;
    }

    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public String show() {
        return value.format(formatter);
    }

    @Override
    public String toString() {
        return "ThreadCreatedTime{" +
                "value=" + value +
                '}';
    }
}
