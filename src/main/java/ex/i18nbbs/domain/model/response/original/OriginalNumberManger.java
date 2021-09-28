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
        String[] strAry = uuidText.substring(4,28).split("-");
        StringBuilder builder = new StringBuilder();
        for (String s : strAry) {
            builder.append(s);
        }
        return builder.toString();
    }
}
