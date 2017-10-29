package service;

import model.Meal;

import model.Menu;
import model.MenuMeal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.datajpa.MealRepository;
import repository.datajpa.MenuRepository;
import transferObjects.MealTO;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class MealService  {

    @Autowired
    private MealRepository mealRepository;
    @Autowired
    private MenuRepository menuRepository;
    public void testSave(){
        Meal nMeal = new Meal("testMeal",900);
        Menu nMenu = new Menu("testDinner","testCook");
        MenuMeal menuMeal = new MenuMeal();
        menuMeal.setMeal(nMeal);
        menuMeal.setMenu(nMenu);
        nMeal.getMenumeals().add(menuMeal);
        menuRepository.save(nMenu);
        mealRepository.save(nMeal);
    }

    public List<MealTO> getAll() {
        List<Meal> lm = mealRepository.findAll();
        List<MealTO> lmto = new ArrayList<>();

        lm.forEach(meal ->
                meal.getMenumeals().forEach(menuMeal -> {

            lmto.add(new MealTO(meal.getId(),
                    meal.getName(),
                    meal.getPrice(),
                    menuMeal.getMenu().getId(),
                    menuMeal.getMenu().getName()
                    ));
        }));

        return lmto;
    }

    public List<Meal> testGet(){
        return mealRepository.findAll();
    }

    public void create(Meal object) {
        mealRepository.save(object);
    }


    public Meal get(Integer id) {
        return mealRepository.findOne(id);
    }

    @Transactional
    public void update(Meal object) {
        mealRepository.save(object);
    }


    public void delete(Integer id) {
        mealRepository.delete(id);
    }
}
