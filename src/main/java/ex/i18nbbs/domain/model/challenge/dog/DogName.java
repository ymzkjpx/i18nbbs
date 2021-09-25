package ex.i18nbbs.domain.model.challenge.dog;

public class DogName {
    String value;

    @Deprecated
    DogName(){}

    public DogName(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return "DogName{" +
                "value='" + value + '\'' +
                '}';
    }
}
