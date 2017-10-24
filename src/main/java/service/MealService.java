package service;

import model.Meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.datajpa.MealRepository;

import service.interfaces.VoteSystemService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MealService  {
    private final Meal potatoes = new Meal(8,"картошка",100);
    private final Meal soup =     new Meal(26,"борщ",100);
    private final Meal meat =     new Meal(23,"мясо",1500);
    private final Meal fish =     new Meal(27,"рыба",200);
    private final Meal mushrooms =new Meal(745,"грибы",400);
    private final Meal bread =     new Meal(746,"хлеб",300);
    @Autowired
    private MealRepository mealRepository;

    public void fillRepository() {
        mealRepository.save(potatoes);
        mealRepository.save(soup);
        mealRepository.save(meat);
        mealRepository.save(fish);
        mealRepository.save(mushrooms);
        mealRepository.save(bread);
    }



    public List<Meal> getAll() {
        List<Meal> lm = new ArrayList<>();
        Iterable<Meal> im = mealRepository.findAll();
        im.forEach(meal -> {
            lm.add(meal);
        });
        return lm;
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
