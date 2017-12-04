package web;


import model.Role;
import model.User;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class RootController {


    @RequestMapping(value = "/",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public String welcome(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       User user = (User) authentication.getPrincipal();
        model.addAttribute("username", user.getUsername());
        model.addAttribute("roles",user.getAuthorities());

        return "index";
    }

    @RequestMapping(value = "/admin",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public String
    admin(Model model) {

        return "admin";
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

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "notModelPages/register";
    }

}
