package service;

import model.Role;
import model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService  {
    private final User adminUser = new User(
            40000,
            "Василий",
            "123@gmail.com",
            "123",
            Role.ADMIN);
    private final User regularUser=  new User(
            50000,
            "Петр",
            "aaa123@yandex.ru",
            "123",
            Role.USER);
    public void fillRepository(){

    }




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
