package ex.i18nbbs.presentation.web.thread;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ex.i18nbbs.application.thread.ThreadRegisterService;
import ex.i18nbbs.domain.model.thread.Thread;

/**
 * 新規スレッド建設コントローラー
 */
@Controller
@RequestMapping("/thread/post")
public class ThreadPostController {

    ThreadRegisterService threadRegisterService;

    public ThreadPostController(ThreadRegisterService threadRegisterService) {
        this.threadRegisterService = threadRegisterService;
    }

    @GetMapping
    String index(@ModelAttribute("thread")Thread thread){
        return "thread/form";
    }

    @PostMapping(params = "newThread")
    String formPost(@ModelAttribute("thread") @Validated Thread thread, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return "thread/form";
        threadRegisterService.register(thread);

        // TODO: 投稿したスレッドに遷移する.
        return "redirect:/";
    }

    @InitBinder
    void initBinder(WebDataBinder binder) {
        binder.setAllowedFields(
                "threadTheme.threadTitle.value",
                "threadTheme.threadOwner.value",
                "responses.list*"
        );
    }
}
