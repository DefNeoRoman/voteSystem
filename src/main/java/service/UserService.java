package service;

import model.Role;
import model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService  {





    public List<User> getAll() {
        return new ArrayList<>();
    }


    public void create(String searchKey, User object) {

    }


    public User get(Long searchKey) {
        return new User();
    }


    public void update(String searchKey, User object) {


    }


    public void delete(Long searchKey) {

    }

}
