package ex.i18nbbs.domain.model.response.original;

/**
 * 返信文章(投稿時点)
 */
public class Original {
    OriginalNumber originalNumber = OriginalNumber.nextNumber();
    OriginalMessage originalMessage = OriginalMessage.empty();

    public Original(){}

    public Original(OriginalNumber originalNumber, OriginalMessage originalMessage) {
        this.originalNumber = originalNumber;
        this.originalMessage = originalMessage;
    }

    public OriginalNumber showOriginalNumber(){
        return originalNumber;
    }

    public OriginalMessage originalMessage() {
        return originalMessage;
    }

    public static Original refreshNumber(Original other){
        OriginalNumber originalNumber = OriginalNumber.nextNumber();
        return new Original(originalNumber, other.originalMessage());
    }

    @Override
    public String toString() {
        return "Original{" +
                "originalNumber=" + originalNumber +
                ", originalMessage=" + originalMessage +
                '}';
    }
}
