package service;

import model.Role;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.interfaces.UserRepository;
import service.interfaces.VoteSystemService;

import java.util.List;

@Service
public class UserService implements VoteSystemService<User> {
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


    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public void create(String searchKey, User object) {

    }

    @Override
    public User get(String searchKey) {
        return userRepository.get(searchKey);
    }

    @Override
    public void update(String searchKey, User object) {


    }

    @Override
    public void delete(String searchKey) {
        userRepository.delete(searchKey);
    }
    public Integer getSize(){
        return userRepository.getAll().size();
    }
}
