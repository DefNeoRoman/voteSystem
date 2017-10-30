package web.controllers;

import model.Meal;
import model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.MealService;
import service.MenuService;
import transferObjects.MealTO;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.*;

@RestController
@RequestMapping(value = "/meals")
public class MealController {

    @Autowired
    MealService mealService;
    @Autowired
    MenuService menuService;



    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MealTO> getAll(Model model){
        return mealService.getAll();
    }
    //будет разделение логики на update и add
    @GetMapping(value = "edit/{mealId}/{menuId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MealTO get(@PathVariable("mealId") Long mealId,
                                  @PathVariable("menuId") Long menuId
                                  ) {
        List<Menu> menuList = menuService.getAll();

        Meal meal = mealService.get(mealId);
        Menu menu = menuService.get(menuId);
        MealTO response = new MealTO(mealId,
                meal.getName(),meal.getPrice(),
                menuId,menu.getName());
        menuList.forEach(menu1 -> {
//            добавляем доступные для options
            response.addMenuId(menu1.getId());
            response.addMenuname(menu1.getName());
        });


        return response;
    }
    @PostMapping(value = "/update")
    public List<MealTO> update(@RequestParam (required=false)String mealId,
                         @RequestParam String menuId,
                         @RequestParam(required=false) String  mealName,
                         @RequestParam(required=false) String price) {
        List<MealTO> lmto =new ArrayList<>();

        Meal upMeal = mealService.get(Long.parseLong(mealId));
        upMeal.setName(mealName);
        upMeal.setPrice(Integer.valueOf(price));
        Menu upMenu = menuService.get(Long.parseLong(menuId));
        upMenu.addMeal(upMeal);

        menuService.update(upMenu);
        mealService.update(upMeal);
        return mealService.getAll();
    }
    @DeleteMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        mealService.delete(id);
        return "redirect:/meals";
    }
}
