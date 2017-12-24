package web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserService;


@Controller
public class RootController {
    @Autowired
    UserService service;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String welcome() {


        return "index";
    }

    @GetMapping("/login")
    public String getLogin(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Model model)

    {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "notModelPages/login";
    }

    @GetMapping("admin/users")
    public String users() {
        return "modelPages/users";
    }

    @GetMapping("/main")
    public String main() {
        return "modelPages/main";
    }

    @GetMapping("admin/meals")
    public String meals() {
        return "modelPages/meals";
    }

    @GetMapping(value = "admin/menus")
    public String menus() {
        return "modelPages/menus";
    }

    @GetMapping(value = "admin/places")
    public String login() {
        return "modelPages/places";
    }

    @GetMapping("admin/voteStory")
    public String voteStory() {
        return "modelPages/voteStory";
    }
}
