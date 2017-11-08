package web;

import com.SpringBootWebApplication;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.controllers.MealController;

@Controller
public class RootController {

    @Autowired
    private ApplicationContext applicationContext;
    @RequestMapping(value = "/",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public String
    welcome(Model model) {

        return "index";
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public String
    login(Model model) {

        return "login";
    }
    @GetMapping("/users")
    public String users() {
        return "modelPages/users";
    }
    @GetMapping("/main")
    public String main() {
        return "modelPages/main";
    }

    @GetMapping("/meals")
    public String meals() {
        return "modelPages/meals";
    }

    @GetMapping(value = "/menus")
    public String menus() {
        return "modelPages/menus";
    }

    @GetMapping(value = "/places")
    public String login() {
        return "modelPages/places";
    }


    @GetMapping("/voteStory")
    public String voteStory() {
        return "modelPages/voteStory";
    }

//    @RequestMapping(value = "/registration", method = RequestMethod.POST)
//    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
//        userValidator.validate(userForm, bindingResult);
//
//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }
//
//        userService.save(userForm);
//
//        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
//
//        return "redirect:/welcome";
//    }
}
