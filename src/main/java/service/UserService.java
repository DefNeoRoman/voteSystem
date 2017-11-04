package service;


import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.datajpa.UserRepository;

import java.util.List;


@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<User> getAll() {

        return repository.findAll();
    }


    public User get(Long searchKey) {

        return repository.findOne(searchKey);
    }


    public void update(User object) {
        repository.save(object);

    }


    public void delete(Long searchKey) {
        repository.delete(searchKey);
    }

}
