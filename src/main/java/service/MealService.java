package service;

import model.Meal;

import model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MealRepository;
import repository.MenuRepository;
import transferObjects.MealTO;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class MealService  {

    @Autowired
    private MealRepository mealRepository;
    @Autowired
    private MenuRepository menuRepository;
    public void testSave(){
        Meal nMeal1 = new Meal("testMeal",900);
        Meal nMeal2 = new Meal("soup",9090);
        Menu nMenu3 = new Menu("testDinner","testCook");
        Menu nMenu4 = new Menu("testSupper","Vova");

       nMenu3.addMeal(nMeal1);
       nMenu3.addMeal(nMeal2);

       nMenu4.addMeal(nMeal1);
       nMenu4.addMeal(nMeal2);

       menuRepository.save(nMenu3);



    }

    public List<MealTO> getAll() {
        List<Meal> lm = mealRepository.findAll();
        List<MealTO> lmto = new ArrayList<>();
        lm.forEach(meal -> {
           meal.getMenus().forEach(menu -> {
               lmto.add(new MealTO(meal.getId(),
                       meal.getName(),
                       meal.getPrice(),
                       menu.getId(),
                       menu.getName()));
           });
        });


        return lmto;
    }

    public List<Meal> testGet(){
        return mealRepository.findAll();
    }

    public void create(Meal object) {
        mealRepository.save(object);
    }


    public Meal get(Long id) {

        return mealRepository.findOne(id);
    }

    @Transactional
    public void update(Meal object) {
        mealRepository.save(object);
    }


    public void delete(Long id) {

        mealRepository.delete(id);
    }
}
