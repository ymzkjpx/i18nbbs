package ex.i18nbbs.domain.model.response.original;

import java.util.UUID;

/**
 * 返信文章IDの生成器
 */
public class OriginalNumberManger {
    private OriginalNumberManger() {
    }

    public static String nextNumber() {
        String uuidText = UUID.randomUUID().toString().toUpperCase();
        return uuidText.substring(4,28).split("-").toString();
    }
}
