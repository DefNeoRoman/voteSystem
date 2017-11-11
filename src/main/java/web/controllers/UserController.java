package web.controllers;

import com.SecurityService;
import com.UserValidator;
import model.Place;
import model.Role;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import service.PlaceService;
import service.UserService;

import java.util.*;

@RestController //by default returns JSON
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    UserService service;

    @Autowired
    private UserValidator userValidator;
    @Autowired
    private SecurityService securityService;
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
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
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String en,
            @RequestParam(required = false) String vote,
            @RequestParam(required = false) String canvote
    ) {
        User upUser;
        if (id == null) {
            upUser = new User();
            upUser.setRoles(new HashSet<>(Collections.singletonList(Role.ROLE_USER)));
        } else {
            upUser = service.get(id);
        }
        if (name.isEmpty()) {
            name = "Empty";
        }
        if (email.isEmpty()) {
            email = "empty";
        }
        if (password.isEmpty()) {
            password = "123";
        }
        boolean enable = en != null;
        boolean isVotes = vote != null;
        boolean canVotes = canvote != null;
        upUser.setName(name);
        upUser.setPassword(password);
        upUser.setEmail(email);
        upUser.setEnabled(enable);
        upUser.setVote(isVotes);
        upUser.setCanVote(canVotes);
        service.update(upUser);

        return service.getAll();
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {

        service.delete(id);
    }

    @PostMapping(value = "/registration",produces = MediaType.APPLICATION_JSON_VALUE)
    public User registration() {
        System.out.println("hello from /registration");
        securityService.autologin("regular", "12345678");
        return new User();
    }

}
