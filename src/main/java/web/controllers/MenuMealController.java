package web.controllers;

import model.MenuMeal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.MenuMealService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/menuMeal")
public class MenuMealController implements VScontroller {

    @Autowired
    MenuMealService service;
    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAll(Model model) {
        model.addAttribute("menuMeals");
        return null;
    }

    @Override
    public String update(HttpServletRequest request) {
        return null;
    }

    @Override
    public String delete(String uuid) {
        return null;
    }
}
