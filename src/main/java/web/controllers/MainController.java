package web.controllers;

import model.Place;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import service.PlaceService;
import service.UserService;
import transferObjects.MenuTO;
import transferObjects.PlaceTO;

import java.util.List;
import java.util.Map;

import static web.RootController.wasIncredId;


@RestController
@RequestMapping(value = "/main")
public class MainController {
    @Autowired
    PlaceService placeService;
    @Autowired
    UserService userService;
    private Authentication auth;

    @GetMapping(value = "/getData", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<PlaceTO, List<MenuTO>> getAll() {
        return placeService.getAllMainTOs();
    }

    @PostMapping(value = "/incVote", produces = MediaType.APPLICATION_JSON_VALUE)
    public void incVote(@RequestParam Long id) {
        wasIncredId.set(id);
        auth  = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        User currentUser = userService.getByName(userName);
        currentUser.setVote(true);
        userService.update(currentUser);
        Place incPlace = placeService.get(id);
        incPlace.incVote();
        placeService.update(incPlace);

    }
    @PostMapping(value = "/decVote", produces = MediaType.APPLICATION_JSON_VALUE)
    public void decVote(@RequestParam Long id) {
        auth  = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        User currentUser = userService.getByName(userName);
        currentUser.setVote(false);
        userService.update(currentUser);
        Place incPlace = placeService.get(id);
        incPlace.decVote();
        placeService.update(incPlace);
        wasIncredId.set(0);
    }



}
