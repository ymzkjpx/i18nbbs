package ex.i18nbbs.presentation.web.thread;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ex.i18nbbs.application.thread.ThreadQueryService;
import ex.i18nbbs.domain.model.thread.headline.Headlines;

/**
 * スレッド見出し一覧コントローラー
 */
@Controller
@RequestMapping("headline")
public class HeadlineController {

    ThreadQueryService threadQueryService;

    public HeadlineController(ThreadQueryService threadQueryService) {
        this.threadQueryService = threadQueryService;
    }

    @GetMapping
    String index(Model model){
        Headlines headlines = threadQueryService.headlines();
        model.addAttribute("headlines", headlines);
        return "thread/newheadline";
    }

}
