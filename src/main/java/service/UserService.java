package service;


import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.List;


@Service
public class UserService {
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    UserRepository repository;

    public List<User> getAll() {

        return repository.findAll();
    }


    public User get(Long searchKey) {

        return repository.findOne(searchKey);
    }


    public void update(User object) {
        String password = object.getPassword();
        object.setPassword(passwordEncoder.encode(password));
        repository.save(object);
    }


    public void delete(Long searchKey) {
        repository.delete(searchKey);
    }
    public User findByName(String username) {
        return repository.findByName(username);
    }
}
