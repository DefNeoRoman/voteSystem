package web;


import model.Role;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.Collections;
import java.util.HashSet;


@Controller
public class RootController {
    @Autowired
    UserService service;

    @RequestMapping(value = "/",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public String welcome() {


        return "index";
    }

    @RequestMapping(value = "/admin",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public String
    admin(Model model) {

        return "admin";
    }
    @GetMapping("/login")
    public String getLogin(@RequestParam(value="error",required = false) String error,
                           @RequestParam(value="logout",required = false) String logout,
                           Model model
    )

    {
        model.addAttribute("error", error !=null);
        model.addAttribute("logout",logout != null);
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

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "notModelPages/register";
    }


}
