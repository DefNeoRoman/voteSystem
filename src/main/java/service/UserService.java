package service;


import model.AuthorizedUser;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.List;


@Service("userService")
public class UserService implements UserDetailsService {

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
    public User findByName(String username) {
        return repository.findByName(username);
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = repository.findByName(name);
        if (user == null) {
            throw new UsernameNotFoundException("User " + name + " is not found");
        }
        return new AuthorizedUser(user);
    }
}
