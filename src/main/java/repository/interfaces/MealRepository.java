package repository.interfaces;

import model.Meal;

import java.util.List;

public interface MealRepository {
    void save(Meal meal, String searchKey);   //create
    Meal get(String searchKey);               //read
    void update(Meal meal, String searchKey); //update
    void delete(String searchKey);            //delete
    List<Meal> getAll();                      //getAll
    void clear();
    int size();
    String getSearchKey(String uuid);
    boolean isExist(String searchKey);
}
