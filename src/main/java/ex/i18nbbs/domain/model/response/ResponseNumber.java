package ex.i18nbbs.domain.model.response;

/**
 * 返信のID
 */
public class ResponseNumber {
    String value;

    @Deprecated
    ResponseNumber(){}

    private ResponseNumber(String value) {
        this.value = value;
    }

    public static ResponseNumber nextNumber(){
        String uuidText = ResponseNumberManager.nextNumber();
        return new ResponseNumber(uuidText);
    }

    @Override
    public String toString() {
        return "ResponseNumber{" +
                "value='" + value + '\'' +
                '}';
    }
}
