package service;


import lombok.NonNull;
import model.Role;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.*;


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



   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username);

   }
}
