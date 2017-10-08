package repository.interfaces;

import model.Meal;
import model.MenuMeal;
import model.PlaceMenu;

import java.util.List;

public interface MenuMealRepository {
    void save(MenuMeal menuMeal, String searchKey);   //create
    MenuMeal get(String searchKey);                     //read
    void update(MenuMeal menuMeal, String searchKey); //update
    void delete(String searchKey);                      //delete
    List<MenuMeal> getAll();                              //getAll
    void clear();
    int size();
    String getSearchKey(String uuid);
    boolean isExist(String searchKey);
}
