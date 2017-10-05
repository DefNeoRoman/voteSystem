package repository.interfaces;

import model.MenuMeal;
import model.PlaceMenu;

import java.util.List;

public interface MenuMealRepository {
    MenuMeal save(MenuMeal menuMeal);     //create
    MenuMeal get(int id);          //read
    void update(MenuMeal menuMeal);   //update
    boolean delete(int id);     //delete
    List<MenuMeal> getAll();        //getAll
}
