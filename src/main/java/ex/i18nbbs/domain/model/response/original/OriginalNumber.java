package ex.i18nbbs.domain.model.response.original;

import javax.validation.constraints.NotNull;

/**
 * 返信文章のID
 */
public class OriginalNumber {
    @NotNull
    String value;

    @Deprecated
    OriginalNumber() {
    }

    private OriginalNumber(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static OriginalNumber nextNumber(){
        String nextNumber = OriginalNumberManger.nextNumber();
        return new OriginalNumber(nextNumber);
    }

    @Override
    public String toString() {
        return "OriginalNumber{" +
                "value='" + value + '\'' +
                '}';
    }
}
