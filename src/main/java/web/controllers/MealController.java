package web.controllers;

import model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sandbox.SandBox;
import service.MealService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

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

    @PostMapping(value = "/update")

    public String update(HttpServletRequest request) {
        Integer id = Integer.valueOf(request.getParameter("id"));

        Meal upMeal = new Meal();



        String name = request.getParameter("description");
        if(name.isEmpty()){
            name = "empty";
        }
        Integer price = Integer.valueOf(request.getParameter("price"));
        if (price == null){
            price = 0;
        }

        upMeal.setName(name);
        upMeal.setPrice(price);
        service.update(upMeal);

        return "redirect:/meals";
    }
    @GetMapping(value = "delete/{uuid}")

    public String delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return "redirect:/meals";
    }
}
