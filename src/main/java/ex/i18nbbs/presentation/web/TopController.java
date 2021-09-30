package ex.i18nbbs.presentation.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * トップページリダイレクト用コントローラー
 */
@Controller
@RequestMapping("/")
public class TopController {
    @GetMapping
    String index(){
        return "redirect:/headline";
    }
}
