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

import ex.i18nbbs.application.thread.ThreadQueryService;
import ex.i18nbbs.application.thread.ThreadRegisterService;
import ex.i18nbbs.domain.model.response.Response;
import ex.i18nbbs.domain.model.thread.Thread;
import ex.i18nbbs.domain.model.thread.ThreadNumber;
import ex.i18nbbs.presentation.web.thread.viewmodel.ResponseRequest;

/**
 * スレッド履歴コントローラー
 */
@Controller
@RequestMapping("thread")
public class ThreadController {

    ThreadQueryService threadQueryService;
    ThreadRegisterService threadRegisterService;

    public ThreadController(ThreadQueryService threadQueryService, ThreadRegisterService threadRegisterService) {
        this.threadQueryService = threadQueryService;
        this.threadRegisterService = threadRegisterService;
    }

    @GetMapping
    String accessingInvalidUrls() {
        return "redirect:/";
    }

    @GetMapping("{threadNumber}")
    String index(Model model, @PathVariable("threadNumber") ThreadNumber threadNumber) {
        if (!threadQueryService.existsThread(threadNumber)) return "error/404/notfound";
        Thread thread = threadQueryService.findThreadByThreadNumber(threadNumber);
        model.addAttribute("thread", thread);

        // TODO メソッドレベルのModelAttributeとして切り出す
        model.addAttribute("responseRequest", ResponseRequest.empty());

        return "thread/thread";
    }

    @PostMapping(path = "{threadNumber}", params = "newResponse")
    String newResponse(@ModelAttribute("responseRequest") ResponseRequest responseRequest,
                       @PathVariable ThreadNumber threadNumber,
                       BindingResult bindingResult) {
        if (responseRequest == null) return "thread/newheadline";
        if (bindingResult.hasErrors()) return String.format("thread/%s",threadNumber.value());
        ThreadNumber requestThreadNumber = responseRequest.threadNumber();
        Response requestResponse = responseRequest.response();
        threadRegisterService.newResponse(requestThreadNumber, requestResponse);
        return String.format("redirect:/thread/%s",threadNumber.value());
    }

    @InitBinder
    void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setAllowedFields(
                "response.responseOwner.value",
                "response.original.originalMessage.value",
                "threadNumber.value",
                "response.postTime.value"
        );
    }

}
