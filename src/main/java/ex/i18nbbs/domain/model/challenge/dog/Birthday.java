package ex.i18nbbs.domain.model.challenge.dog;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Birthday {
    LocalDate value;

    @Deprecated
    Birthday(){}

    public Birthday(LocalDate value) {
        this.value = value;
    }

    public LocalDate value() {
        return value;
    }

    public int age(){
        return Math.toIntExact(ChronoUnit.YEARS.between(value,LocalDate.now()));
    }

    public long elapsedDays(){
        return ChronoUnit.DAYS.between(value, LocalDate.now());
    }

    public static Birthday today(){
        return new Birthday(LocalDate.now());
    }

    @Override
    public String toString() {
        return "Birthday{" +
                "value=" + value +
                '}';
    }
}
