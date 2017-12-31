package web.controllers;

import model.Role;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.*;

@RestController
@RequestMapping(value = "admin/users")
public class UserController {
    @Autowired
    UserService service;
    @GetMapping(value = "/getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {

        return service.getAll();
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(@PathVariable("id") Long id) {
        return service.get(id);
    }
    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> update(
            @RequestParam(required = false) Long id,
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String en,
            @RequestParam(required = false) String vote,
            @RequestParam(required = false) String canvote
    ) {
        User upUser;
        if (id == null) {
            upUser = new User();
            upUser.setAuthorities(
                    new HashSet<>(Collections.singletonList(Role.ROLE_USER)));
            upUser.setEnabled(true);
            upUser.setCanVote(true);
            upUser.setVote(false);
            upUser.setAccountNonExpired(true);
            upUser.setAccountNonLocked(true);
            upUser.setCredentialsNonExpired(true);
        } else {
            upUser = service.get(id);
            boolean enable = en != null;
            boolean isVotes = vote != null;
            boolean canVotes = canvote != null;
            upUser.setEnabled(enable);
            upUser.setVote(isVotes);
            upUser.setCanVote(canVotes);
        }
        if (username.isEmpty()) {
            username = "Empty";
        }
        if (email.isEmpty()) {
            email = "empty";
        }
        if (password.isEmpty()) {
            password = "123";
        }
        upUser.setUsername(username);
        upUser.setPassword(password);
        upUser.setEmail(email);
        service.save(upUser);
        return service.getAll();
    }
    @DeleteMapping
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }
    @PostMapping(value = "/registerUser",produces = MediaType.APPLICATION_JSON_VALUE)
    public void registration( @RequestParam(required = false) String name,
                                @RequestParam String email,
                                @RequestParam(required = false) String password) {
        User nUser = new User(name,password, new HashSet<>(Collections.singleton(Role.ROLE_USER)));
        nUser.setEmail(email);
        nUser.setCanVote(true);
        nUser.setEnabled(true);
        nUser.setAccountNonExpired(true);
        nUser.setAccountNonLocked(true);
        nUser.setCredentialsNonExpired(true);
        service.save(nUser);

    }
}
