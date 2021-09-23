package ex.i18nbbs.presentation.web.thread;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ex.i18nbbs.application.thread.ThreadQueryService;
import ex.i18nbbs.domain.model.thread.Thread;
import ex.i18nbbs.domain.model.thread.ThreadNumber;

@Controller
@RequestMapping("thread")
public class ThreadController {

    ThreadQueryService threadQueryService;

    public ThreadController(ThreadQueryService threadQueryService) {
        this.threadQueryService = threadQueryService;
    }

    @GetMapping("{threadId}")
    String index(Model model, @PathVariable("threadId") ThreadNumber threadNumber){
        System.out.println(threadNumber);
        ThreadNumber mockThreadNumber = new ThreadNumber(1);
        Thread thread = threadQueryService.findByThreadNumber(mockThreadNumber);
        model.addAttribute("thread", thread);
        return "thread/thread";
    }

    @InitBinder
    void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setAllowedFields(
                "threadNumber.value"
        );
    }

}
