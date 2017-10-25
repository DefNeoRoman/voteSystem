package service;

import model.Meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.datajpa.MealRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MealService  {

    @Autowired
    private MealRepository mealRepository;
    public List<Meal> getAll() {
        List<Meal> lm = new ArrayList<>();
        Iterable<Meal> im = mealRepository.findAll();
        im.forEach(lm::add);
        return lm;
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


    public void update(Meal object) {
        mealRepository.save(object);
    }


    public void delete(Integer id) {
        mealRepository.delete(id);
    }
}
