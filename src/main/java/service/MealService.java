package service;

import model.Meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.interfaces.MealRepository;

import service.interfaces.VoteSystemService;

import java.util.List;
import java.util.UUID;

@Service
public class MealService implements VoteSystemService<Meal> {
    private final Meal potatoes = new Meal(UUID.randomUUID().toString(),"картошка",100);
    private final Meal soup = new Meal(UUID.randomUUID().toString(),"борщ",100);
    private final Meal meat = new Meal(UUID.randomUUID().toString(),"мясо",1500);
    private final Meal fish = new Meal(UUID.randomUUID().toString(),"рыба",200);
    private final Meal mushrooms = new Meal(UUID.randomUUID().toString(),"грибы",400);
    private final Meal bread = new Meal(UUID.randomUUID().toString(),"хлеб",300);
    @Autowired
    private MealRepository mealRepository;

    public void fillRepository() {
        mealRepository.save(potatoes,potatoes.getUuid());
        mealRepository.save(soup,soup.getUuid());
        mealRepository.save(meat,meat.getUuid());
        mealRepository.save(fish,fish.getUuid());
        mealRepository.save(mushrooms,mushrooms.getUuid());
        mealRepository.save(bread,bread.getUuid());
    }


    @Override
    public List<Meal> getAll() {
        return mealRepository.getAll();
    }

    @Override
    public void create(String searchKey, Meal object) {
        mealRepository.save(object,searchKey);
    }

    @Override
    public Meal get(String searchKey) {
        return mealRepository.get(searchKey);
    }

    @Override
    public void update(String searchKey, Meal object) {
        mealRepository.update(object,searchKey);
    }

    @Override
    public void delete(String searchKey) {
        mealRepository.delete(searchKey);
    }
}
