package ex.i18nbbs.domain.model.challenge.datetime;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class DateRequest {
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    LocalDate value;

    DateRequest(){}

    public DateRequest(LocalDate value) {
        this.value = value;
    }

    public static DateRequest empty(){
        return new DateRequest();
    }

    public LocalDate value() {
        return value;
    }
}
