package repository.interfaces;

import model.Meal;

import java.util.List;

public interface MealRepository {
    void save(Meal meal);   //create
    Meal get(int id);       //read
    void update(Meal meal); //update
    boolean delete(int id); //delete
    List<Meal> getAll();    //getAll
}
