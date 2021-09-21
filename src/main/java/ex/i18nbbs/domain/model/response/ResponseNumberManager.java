package ex.i18nbbs.domain.model.response;

import java.util.UUID;

/**
 * 返信IDの生成器
 */
public class ResponseNumberManager {
    public static String nextNumber(){
        return UUID.randomUUID().toString().toLowerCase();
    }
}
