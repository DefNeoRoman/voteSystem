package service;

import model.Place;
import model.Role;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.interfaces.MenuRepository;
import repository.interfaces.UserRepository;
import service.interfaces.VoteSystemService;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements VoteSystemService<User> {
    private final User adminUser = new User(
            UUID.randomUUID().toString(),
            "Василий",
            "123@gmail.com",
            "123",
            Role.ADMIN);
    private final User regularUser=  new User(
            UUID.randomUUID().toString(),
            "Петр",
            "aaa123@yandex.ru",
            "123",
            Role.USER);
    public void fillRepository(){
        userRepository.save(adminUser,adminUser.getUuid());
        userRepository.save(regularUser,regularUser.getUuid());
    }


    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public void create(String searchKey, User object) {
        userRepository.save(object,object.getUuid());
    }

    @Override
    public User get(String searchKey) {
        return userRepository.get(searchKey);
    }

    @Override
    public void update(String searchKey, User object) {
        userRepository.update(object,object.getUuid());
    }

    @Override
    public void delete(String searchKey) {
        userRepository.delete(searchKey);
    }
    public Integer getSize(){
        return userRepository.getAll().size();
    }
}
