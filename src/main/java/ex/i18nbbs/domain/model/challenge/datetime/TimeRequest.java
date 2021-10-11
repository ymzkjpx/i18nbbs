package ex.i18nbbs.domain.model.challenge.datetime;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;

public class TimeRequest {
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    LocalTime value;

    TimeRequest() {
    }

    public TimeRequest(LocalTime value) {
        this.value = value;
    }

    public LocalTime value() {
        return value;
    }
}
