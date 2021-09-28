package ex.i18nbbs.presentation.web.thread;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ex.i18nbbs.application.thread.ThreadQueryService;
import ex.i18nbbs.domain.model.response.Response;
import ex.i18nbbs.domain.model.thread.Thread;
import ex.i18nbbs.domain.model.thread.ThreadNumber;

@Controller
@RequestMapping("thread")
public class ThreadController {

    ThreadQueryService threadQueryService;

    public ThreadController(ThreadQueryService threadQueryService) {
        this.threadQueryService = threadQueryService;
    }

    @GetMapping
    String accessingInvalidUrls() {
        return "redirect:/";
    }

    @GetMapping("{threadNumber}")
    String index(Model model, @PathVariable("threadNumber") ThreadNumber threadNumber) {
        if (!threadQueryService.existsThread(threadNumber)) return "error/404/notfound";
        Thread thread = threadQueryService.findByThreadNumber(threadNumber);
        model.addAttribute("thread", thread);
        model.addAttribute("response", new Response());
        return "thread/thread";
    }

    @RequestMapping(path = "{threadNumber}", method = RequestMethod.POST, params = "newResponse")
    String newResponse(@ModelAttribute("response") Response response,
                       @PathVariable("threadNumber") ThreadNumber threadNumber,
                       BindingResult bindingResult) {
        if (!threadQueryService.existsThread(threadNumber)) return "thread/newheadline";
        if (bindingResult.hasErrors()) return String.format("thread/%s", threadNumber);
        System.out.println(response);
        threadRegisterService.newRespponse(response);

        // TODO: 投稿したthreadNumberに戻す
        return "redirect:/";
    }

    @InitBinder
    void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setAllowedFields(
                "threadNumber.value",
                "responseOwner.value",
                "original.originalMessage.value"
        );
    }

}
