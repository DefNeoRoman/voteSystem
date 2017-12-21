package service;

import model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MealRepository;
import repository.MenuRepository;
import transferObjects.MealTO;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MealService {

    @Autowired
    private MealRepository mealRepository;
    @Autowired
    private MenuRepository menuRepository;


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

    public List<Meal> testGet() {
        return mealRepository.findAll();
    }

    public void create(Meal object) {
        mealRepository.save(object);
    }


    public Meal get(Long id) {

        return mealRepository.findOne(id);
    }

    public void update(Meal object) {
        mealRepository.save(object);
    }

    public void delete(Long id) {
        mealRepository.delete(id);
    }
}
