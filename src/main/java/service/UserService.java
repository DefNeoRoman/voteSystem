package service;


import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.List;


@Service("userService")
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository repository;
    @Autowired
    private  BCryptPasswordEncoder PASSWORD_ENCODER;
    public List<User> getAll() {

        return repository.findAll();
    }
    public User get(Long searchKey) {

        return repository.findOne(searchKey);
    }
    public void save (User user){
        repository.save(prepareToSave(user));
    }
    public void update(User user) {
        repository.save(user);
    }
    public void delete(Long searchKey) {
        repository.delete(searchKey);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username);

    }
    public User getByName(String name) {
        return repository.findByUsername(name);

    }
    public User prepareToSave(User user) {
        user.setPassword(PASSWORD_ENCODER.encode(user.getPassword()));
        user.setEmail(user.getEmail().toLowerCase());
        return user;
    }

  }
