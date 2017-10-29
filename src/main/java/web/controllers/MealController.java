package web.controllers;

import model.Meal;
import model.Menu;
import model.MenuMeal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.MealService;
import service.MenuService;
import transferObjects.MealTO;

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
    public MealTO get(@PathVariable("mealId") Integer mealId,
                                  @PathVariable("menuId") Integer menuId
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
    @Transactional
    public List<MealTO> update(@RequestParam (required=false)String mealId,
                         @RequestParam String menuId,
                         @RequestParam(required=false) String  mealName,
                         @RequestParam(required=false) String price) {
        List<MealTO> lmto;

        Meal upMeal;
        System.out.println(menuId);
        Menu upMenu = menuService.get(Integer.valueOf(menuId));
        if(mealId.isEmpty()){
            upMeal = new Meal();
        }else{
            upMeal = mealService.get(Integer.valueOf(mealId));
        }
        if(mealName.isEmpty()){
            mealName = "Empty";
        }
        if(price.isEmpty()){
            price = "0";
        }
        upMeal.setName(mealName);
        upMeal.setPrice(Integer.valueOf(price));
        upMeal.addMenuMeal(new MenuMeal(upMenu,upMeal));

       mealService.update(upMeal);

       lmto = mealService.getAll();

        return lmto;
    }
    @DeleteMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        mealService.delete(id);
        return "redirect:/meals";
    }
}
