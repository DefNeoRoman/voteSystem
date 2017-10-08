package web.controllers;

import model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sandbox.SandBox;
import service.MealService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/meals")
public class MealController {


    private static MealService service = new MealService();
    static {
        service.fillRepository();
    }
    @RequestMapping(value = "/update",  method = RequestMethod.GET)
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
}
