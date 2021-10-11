package ex.i18nbbs.presentation.web.challenge;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

import ex.i18nbbs.domain.model.challenge.datetime.DateRequest;
import ex.i18nbbs.domain.model.challenge.datetime.DateRequestWithCarryover;
import ex.i18nbbs.domain.model.challenge.datetime.DateTimeRequest;
import ex.i18nbbs.domain.model.challenge.datetime.DateTimeRequestWithCarryover;

@Controller
@RequestMapping("datetime")
public class DateTimeController {

    @ModelAttribute
    DateTimeRequest dateTimeRequest() {
        return DateTimeRequest.empty();
    }

    @ModelAttribute
    DateRequest dateRequest() {
        return DateRequest.empty();
    }

    @ModelAttribute
    DateRequestWithCarryover dateRequestWithCarryover() {
        return DateRequestWithCarryover.empty();
    }

    @ModelAttribute
    DateTimeRequestWithCarryover dateTimeRequestWithCarryover() {
        return DateTimeRequestWithCarryover.empty();
    }

    @GetMapping
    String index(Model model) {
        return "challenge/datetime";
    }

    @PostMapping(params = "toLocalDateTime")
    String post(@ModelAttribute("dateTimeRequest") DateTimeRequest dateTimeRequest,
                BindingResult bindingResult,
                Model model) {
        System.out.println(dateTimeRequest);
        return "redirect:/datetime";
    }

    @PostMapping(params = "toLocalDate")
    String post(@ModelAttribute("dateRequest") DateRequest dateRequest,
                BindingResult bindingResult,
                Model model) {
        System.out.println(dateRequest);
        return "redirect:/datetime";
    }

    @PostMapping(params = "toLocalDateTimeByText")
    String toLocalDateTimeByText(@ModelAttribute("dateTimeRequest") DateTimeRequest dateTimeRequest,
                                 BindingResult bindingResult,
                                 Model model) {
        System.out.println(dateTimeRequest);
        return "redirect:/datetime";
    }

    @PostMapping(params = "toLocalDateByText")
    String toLocalDateByText(@ModelAttribute("dateRequest") DateRequest dateRequest,
                             BindingResult bindingResult,
                             Model model) {
        System.out.println(dateRequest);
        return "redirect:/datetime";
    }

    @PostMapping(params = "toLocalDateByTextWithTime")
    String toLocalDateByTextWithTime(
            @ModelAttribute("DateRequestWithCarryover") DateRequestWithCarryover dateRequestWithCarryover,
            BindingResult bindingResult,
            Model model) {
        System.out.println(dateRequestWithCarryover);
        return "redirect:/datetime";
    }

    @PostMapping(params = "doubleBind")
    String doubleBind(
            @ModelAttribute("DateRequestWithCarryover") DateRequestWithCarryover dateRequestWithCarryover,
            @ModelAttribute("dateTimeRequestWithCarryover") DateTimeRequestWithCarryover dateTimeRequestWithCarryover,
            BindingResult bindingResult,
            Model model) {
        System.out.println("" + dateRequestWithCarryover + dateTimeRequestWithCarryover);
        return "redirect:/datetime";
    }

    @InitBinder
    void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setAllowedFields(
                "value"
        );
    }
}
