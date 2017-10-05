package repository;

import model.Meal;
import repository.interfaces.MealRepository;

import java.util.ArrayList;
import java.util.List;

public class MealRepositoryImpl implements MealRepository {
    private List<Meal> meals;
    public MealRepositoryImpl() {
        meals = new ArrayList<>();
    }

    @Override
    public void save(Meal meal) {
        meals.add(meal);
    }

    @Override
    public Meal get(int id) {

        return meals.get(id);
    }

    @Override
    public void update(Meal meal) {
       meals.set(meal.getId(),meal);
    }

    @Override
    public boolean delete(int id) {
        if(meals.contains(meals.get(id))){
            meals.remove(id);
            return true;
        }else{
            return false;
        }

    }

    @Override
    public List<Meal> getAll() {
        return meals;
    }
}
