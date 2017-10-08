package repository.interfaces;

import model.Place;
import model.PlaceMenu;
import model.User;

import java.util.List;

public interface PlaceRepository {
    void save(Place place, String searchKey);   //create
    Place get(String searchKey);                //read
    void update(Place place, String searchKey); //update
    void delete(String searchKey);              //delete
    List<Place> getAll();                       //getAll
    void clear();
    int size();
    String getSearchKey(String uuid);
    boolean isExist(String searchKey);
}
