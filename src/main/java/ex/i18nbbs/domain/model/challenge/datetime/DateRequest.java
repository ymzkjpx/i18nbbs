package ex.i18nbbs.domain.model.challenge.datetime;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class DateRequest {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
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
