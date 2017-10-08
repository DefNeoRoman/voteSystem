package repository.interfaces;

import model.Meal;
import model.Menu;

import java.util.List;

public interface MenuRepository {
    void save(Menu menu, String searchKey);   //create
    Menu get(String searchKey);               //read
    void update(Menu menu, String searchKey); //update
    void delete(String searchKey);            //delete
    List<Menu> getAll();                      //getAll
    void clear();
    int size();
    String getSearchKey(String uuid);
    boolean isExist(String searchKey);
}
