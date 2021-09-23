package ex.i18nbbs.domain.model.response.original;

/**
 * 返信文章の文字列(投稿時点)
 */
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

    @Override
    public String toString() {
        return "OriginalMessage{" +
                "value='" + value + '\'' +
                '}';
    }
}
