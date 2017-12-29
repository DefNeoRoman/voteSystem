package web;


import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserService;

import java.util.concurrent.atomic.AtomicLong;
@Controller
public class RootController {
    private Authentication auth;
    public static AtomicLong wasIncredId = new AtomicLong(0);
    @Autowired
    UserService userService;
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String welcome(Model model) {
        auth  = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        User currentUser = userService.getByName(userName);
        boolean vote = currentUser.isVote();
        model.addAttribute("wasIncredId",wasIncredId);
        if(vote){
            model.addAttribute("vote",true);
        }else{
            model.addAttribute("vote",false);
        }
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
    public String main(Model model) {
        auth  = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        User currentUser = userService.getByName(userName);
        boolean vote = currentUser.isVote();
        model.addAttribute("wasIncredId",wasIncredId);
        if(vote){
            model.addAttribute("vote",true);
        }else{
            model.addAttribute("vote",false);
        }
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
