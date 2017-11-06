package de.dhbw.mosbach.inf16a.kochbuch.registration;

import de.dhbw.mosbach.inf16a.kochbuch.authentication.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author Annika Schatz
 * @author Tobias Bloch
 * @author Irina Eurich
 */
@Controller
public class RegistrationController {

    @Autowired
    IRegistrationService service;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    /*@GetMapping(value = "/user/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDTO userDto = new UserDTO();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @PostMapping(value ="/user/registration")
    public ModelAndView registerUserAccount (@ModelAttribute("user")@Valid UserDTO accountDto, BindingResult result, WebRequest request, Errors errors){
        User registered = new User();
        if (!result.hasErrors()) {
            registered = createUserAccount(accountDto, result);
        }
        if (registered == null) {
            result.rejectValue("email", "message.regError");
        }
        if (result.hasErrors()) {
            return new ModelAndView("registrationFailed", "user", accountDto);
        }
        else {
            return new ModelAndView("successRegister", "user", accountDto);
        }
    }*/

    @PostMapping(value = "/user/registration")
    @ResponseBody
    public GenericResponse registerUserAccount(@RequestBody UserDTO accountDto, final HttpServletRequest request) {
        final User registered = service.registerNewUserAccount(accountDto);
        eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, request.getLocale(), getAppUrl(request)));
        return new GenericResponse("success");
    }

    /*private User createUserAccount(UserDTO accountDto, BindingResult result) {
        User registered = null;
        try {
            registered = service.registerNewUserAccount(accountDto);
        } catch (UserAlreadyExistException e) {
            return null;
        }
        return registered;
    }*/

    private String getAppUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }

}
