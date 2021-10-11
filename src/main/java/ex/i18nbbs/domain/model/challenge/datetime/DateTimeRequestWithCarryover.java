package ex.i18nbbs.domain.model.challenge.datetime;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class DateTimeRequestWithCarryover {
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", fallbackPatterns = {"yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss"})
    LocalDateTime value;

    DateTimeRequestWithCarryover(){}

    public DateTimeRequestWithCarryover(LocalDateTime value) {
        this.value = value;
    }

    public static DateTimeRequestWithCarryover empty(){
        return new DateTimeRequestWithCarryover();
    }

    public LocalDateTime value() {
        return value;
    }
}
