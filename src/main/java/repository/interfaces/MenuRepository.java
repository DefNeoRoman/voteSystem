package repository.interfaces;

import model.Menu;

import java.util.List;

public interface MenuRepository {
    Menu save(Menu menu);   //create
    Menu get(int id);       //read
    void update(Menu menu); //update
    boolean delete(int id); //delete
    List<Menu> getAll();    //getAll
}
