package repository.interfaces;

import model.Place;
import model.User;

import java.util.List;

public interface UserRepository {
    void save(User user, String searchKey);   //create
    User get(String searchKey);                //read
    void update(User user, String searchKey); //update
    void delete(String searchKey);              //delete
    List<User> getAll();                       //getAll
    void clear();
    int size();
    String getSearchKey(String uuid);
    boolean isExist(String searchKey);
}
