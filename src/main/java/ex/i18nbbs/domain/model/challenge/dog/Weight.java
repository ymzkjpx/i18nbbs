package ex.i18nbbs.domain.model.challenge.dog;

public class Weight {
    int value;

    @Deprecated
    Weight(){}

    public Weight(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    @Override
    public String toString() {
        return "Weight{" +
                "value=" + value +
                '}';
    }
}
