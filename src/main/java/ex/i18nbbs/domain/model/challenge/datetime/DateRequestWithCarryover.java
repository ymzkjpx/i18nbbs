package ex.i18nbbs.domain.model.challenge.datetime;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class DateRequestWithCarryover {
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm",
                    fallbackPatterns = {
                            "yyyy-MM-dd", "yyyy-MM-dd HH", "yyyy-MM-dd HH:mm:ss",
                            "yyyy/MM/dd", "yyyy/MM/dd HH:mm", "yyyy/MM/dd HH:mm:ss"
                    })
    LocalDate value;

    @Deprecated
    DateRequestWithCarryover() {
    }

    public DateRequestWithCarryover(LocalDate value) {
        this.value = value;
    }

    public static DateRequestWithCarryover empty() {
        return new DateRequestWithCarryover();
    }

    public LocalDate value() {
        return value;
    }
}
