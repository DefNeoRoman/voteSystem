package web;
import model.Meal;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sandbox.SandBox;
import javax.servlet.http.HttpServletRequest;


@Controller
public class RestController {
    private static SandBox sandBox = new SandBox();

    @RequestMapping(value = "/",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public String
    welcome(Model model) {

        model.addAttribute("users", sandBox.getUsers());
        model.addAttribute("meals", sandBox.getMeals());
        return "first";
    }

    @RequestMapping(value = "/updateMeal",  method = RequestMethod.GET)
    public String updateMeal(HttpServletRequest request, Model model) {
       Meal meal = sandBox.getMeal(request.getParameter("uuid"));
        model.addAttribute("meal",meal);
        return "createMeal";
    }

    @GetMapping("/deleteMeal")
    public String deleteMeal(HttpServletRequest request) {
        String uuid = request.getParameter("uuid");
        sandBox.deleteMeal(uuid);
        return "redirect:/";
    }
    @RequestMapping("/create")
    public String create(Model model) {
        Meal emptyMeal = new Meal("Новая еда", 0);
        model.addAttribute("meal",emptyMeal);
        return "createMeal";
}

    @RequestMapping(value = "/createMeal", method = RequestMethod.POST)
    public String createMeal(HttpServletRequest request){
        String description = request.getParameter("description");
        int price = Integer.valueOf(request.getParameter("price"));
        sandBox.addMeal(new Meal(description,price));
        return "redirect:/";
    }

}
