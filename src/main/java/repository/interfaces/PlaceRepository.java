package repository.interfaces;

import model.Place;
import model.User;

import java.util.List;

public interface PlaceRepository {
    Place save(Place place);     //create
    Place get(int id);          //read
    void update(Place place);   //update
    boolean delete(int id);     //delete
    List<Place> getAll();        //getAll
}
