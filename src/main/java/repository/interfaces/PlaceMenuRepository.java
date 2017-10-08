package repository.interfaces;

import model.Menu;
import model.Place;
import model.PlaceMenu;

import java.util.List;

public interface PlaceMenuRepository {
    void save(PlaceMenu placeMenu, String searchKey);   //create
    PlaceMenu get(String searchKey);                     //read
    void update(PlaceMenu placeMenu, String searchKey); //update
    void delete(String searchKey);                      //delete
    List<PlaceMenu> getAll();                             //getAll
    void clear();
    int size();
    String getSearchKey(String uuid);
    boolean isExist(String searchKey);
}
