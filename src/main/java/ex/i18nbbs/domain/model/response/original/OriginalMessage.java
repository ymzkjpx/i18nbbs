package ex.i18nbbs.domain.model.response.original;

public class OriginalMessage {
   String value;

   @Deprecated
   OriginalMessage(){}

    public OriginalMessage(String value) {
        this.value = value;
    }

    public String value(){
       return value;
    }

    public static OriginalMessage empty(){
       return new OriginalMessage("");
    }

    public static String em(){
       return "";
    }

    @Override
    public String toString() {
        return "OriginalMessage{" +
                "value='" + value + '\'' +
                '}';
    }
}
