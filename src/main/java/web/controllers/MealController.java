package web.controllers;

import model.Meal;
import model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.MealService;
import service.MenuService;
import transferObjects.MealTO;

import java.util.List;

@RestController
@RequestMapping(value = "admin/meals")
public class MealController {

    @Autowired
    MealService mealService;
    @Autowired
    MenuService menuService;


    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public  List<MealTO> getAll() {
        return mealService.getAll();
    }


    @GetMapping(value = "/addMeal", produces = MediaType.APPLICATION_JSON_VALUE)
    public MealTO addMeal() {
        List<Menu> menuList = menuService.getAll();
        MealTO response = new MealTO();
        menuList.forEach(menu1 -> {
            response.addMenuId(menu1.getId());
            response.addMenuname(menu1.getName());
        });

        return response;
    }

    @GetMapping(value = "edit/{mealId}/{menuId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MealTO get(@PathVariable("mealId") Long mealId,
                      @PathVariable("menuId") Long menuId
    ) {
        List<Menu> menuList = menuService.getAll();
        Meal meal = mealService.get(mealId);
        Menu menu = menuService.get(menuId);
        MealTO response = new MealTO(mealId,
                meal.getName(), meal.getPrice(),
                menuId, menu.getName());
        menuList.forEach(menu1 -> {
            response.addMenuId(menu1.getId());
            response.addMenuname(menu1.getName());
        });


        return response;
    }

    @PostMapping(value = "/update")
    public List<MealTO> update(@RequestParam(required = false) String mealId,
                               @RequestParam String menuId,
                               @RequestParam(required = false) String mealName,
                               @RequestParam(required = false) String price) {
        Meal upMeal;
        if (mealId.isEmpty()) {
            upMeal = new Meal();
        } else {
            upMeal = mealService.get(Long.parseLong(mealId));
        }

        upMeal.setName(mealName);
        upMeal.setPrice(Integer.valueOf(price));
        Menu upMenu = menuService.get(Long.parseLong(menuId));
        upMenu.addMeal(upMeal);

        menuService.update(upMenu);
        mealService.update(upMeal);
        return mealService.getAll();
    }

    @DeleteMapping(value = "delete/{mealId}/{menuId}")
    public List<MealTO> delete(@PathVariable("mealId") Long mealId,
                               @PathVariable("menuId") Long menuId) {
        Menu upMenu = menuService.get(menuId);
        Meal upMeal = mealService.get(mealId);

        if (upMenu.getMeals().isEmpty()) {
            menuService.delete(menuId);
        } else {
            upMenu.removeMeal(upMeal);
            menuService.update(upMenu);
            mealService.update(upMeal);
        }


        return mealService.getAll();
    }


}
