package web;

import model.User;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sandbox.SandBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    private static SandBox sandBox = new SandBox();
    @RequestMapping(value = "/",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public @ResponseBody
    List<Object>
    welcome() {

        sandBox.fillRepositories();
        List<Object> objects = new ArrayList<>();
        objects.add(sandBox.getMeals());
        objects.add(sandBox.getUsers());
        return objects;
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
