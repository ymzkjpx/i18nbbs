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

import java.util.ArrayList;

import ex.i18nbbs.domain.model.challenge.dog.Birthday;
import ex.i18nbbs.domain.model.challenge.dog.BreedOfDog;
import ex.i18nbbs.domain.model.challenge.dog.Dog;
import ex.i18nbbs.domain.model.challenge.dog.DogName;
import ex.i18nbbs.domain.model.challenge.dog.Dogs;

@Controller
@RequestMapping("dog")
public class DogController {

    @ModelAttribute("allBreedOfDogs")
    BreedOfDog[] allBreedOfDogs() {
        return BreedOfDog.values();
    }

    @GetMapping
    String index(@ModelAttribute("dogs") Dogs dogs, Model model) {
        System.out.println(dogs);
        Dogs result = dogs.addDog();
        model.addAttribute("dogs", result);
        return "challenge/dog";
    }

    @PostMapping(params = "add")
    String addDogs(@ModelAttribute("dogs") Dogs dogs, BindingResult bindingResult, Model model) {
        Dogs result = dogs.addDog();
        model.addAttribute("dogs", result);
        return "challenge/dog";
    }

    @PostMapping(params = "save")
    String dog(@ModelAttribute("dogs") Dogs dogs, BindingResult bindingResult) {
        System.out.println(dogs);
        return "redirect:/dog";
    }

    @InitBinder
    void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setAllowedFields(
                "dog.dogName.value",
                "list*"
        );
    }
}
