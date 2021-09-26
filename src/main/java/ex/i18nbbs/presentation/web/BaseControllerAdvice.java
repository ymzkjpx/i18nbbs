package ex.i18nbbs.presentation.web;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice(basePackageClasses = BaseControllerAdvice.class)
public class BaseControllerAdvice {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.initDirectFieldAccess();
        binder.setAllowedFields(""); //どのフィールドも許可しない

//        binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
//        binder.registerCustomEditor(Covered.class, new EditorForCovered());
    }


}