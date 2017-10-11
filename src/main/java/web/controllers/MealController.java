package web.controllers;

import model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sandbox.SandBox;
import service.MealService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/meals")
public class MealController {

    @Autowired
    MealService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAll(Model model){
        model.addAttribute("meals",service.getAll());
        return "modelPages/meals";
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Meal get(@PathVariable("uuid") String uuid) {
        return service.get(uuid);
    }

    @RequestMapping(value = "/update",  method = RequestMethod.POST)
    public String updateMeal(HttpServletRequest request, Model model) {

        return "createMeal";
    }

    @GetMapping("/delete")
    public String deleteMeal(HttpServletRequest request) {

        return "redirect:/meals";
    }
    @RequestMapping("/create")
    public String create(Model model) {

        return "createMeal";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createMeal(HttpServletRequest request){

        return "redirect:/";
    }

    @Override
    public String toString() {
        return "MealController from my context";
    }

}
