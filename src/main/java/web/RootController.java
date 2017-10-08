package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
    @GetMapping("/users")
    public String users() {
        return "modelPages/users";
    }

    @GetMapping(value = "/places")
    public String login() {
        return "modelPages/places";
    }

    @GetMapping("/meals")
    public String meals() {
        return "modelPages/meals";
    }

    @GetMapping("/menuMeal")
    public String menuMeal() {
        return "modelPages/menuMeal";
    }

    @GetMapping(value = "/placeMenu")
    public String placeMenu() {
        return "modelPages/placeMenu";
    }

    @GetMapping("/menus")
    public String menus() {
        return "modelPages/menus";
    }

    @GetMapping("/voteStory")
    public String voteStory() {
        return "modelPages/voteStory";
    }
}
