package repository.interfaces;

import model.User;

import java.util.List;

public interface UserRepository {
    void save(User user);   //create
    User get(int id);       //read
    void update(User user); //update
    boolean delete(int id); //delete
    List<User> getAll();    //getAll
    void clear();
}
