package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestController {
    @RequestMapping("/")
    public String welcome() {
        return "first";
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }
    @RequestMapping("/another")
    public String another() {
        return "fragments/another";
    }
}
