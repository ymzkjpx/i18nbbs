package ex.i18nbbs.domain.model.response.original;

import java.util.UUID;

public class OriginalNumberManger {
    private OriginalNumberManger() {
    }

    public static String nextNumber() {
        String uuidText = UUID.randomUUID().toString().toLowerCase();
        return uuidText.substring(4,28).split("-").toString();
    }
}
