package ex.i18nbbs.domain.model.challenge.datetime;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class DateTimeRequest {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    LocalDateTime value;

    DateTimeRequest(){}

    public DateTimeRequest(LocalDateTime value) {
        this.value = value;
    }

    public static DateTimeRequest empty(){
        return new DateTimeRequest();
    }

    public LocalDateTime value() {
        return value;
    }
}
