package repository.interfaces;

import model.Place;
import model.PlaceMenu;

import java.util.List;

public interface PlaceMenuRepository {
    PlaceMenu save(PlaceMenu placeMenu);     //create
    PlaceMenu get(int id);          //read
    void update(PlaceMenu placeMenu);   //update
    boolean delete(int id);     //delete
    List<PlaceMenu> getAll();        //getAll
}
