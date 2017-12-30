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
import service.VoteStoryService;
import transferObjects.MenuTO;
import transferObjects.PlaceTO;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.Constants.TIME_FOR_VOTE;
import static web.RootController.wasIncredId;


@RestController
@RequestMapping(value = "/main")
public class MainController {
    @Autowired
    PlaceService placeService;
    @Autowired
    UserService userService;
    @Autowired
    VoteStoryService voteStoryService;
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
        if(currentUser.isCanVote()){
            currentUser.setVote(true);
            userService.update(currentUser);
            Place incPlace = placeService.get(id);
            incPlace.incVote();
            placeService.update(incPlace);
            voteStoryService.saveOne(currentUser.getId(),incPlace.getId());
        }

    }
    @PostMapping(value = "/decVote", produces = MediaType.APPLICATION_JSON_VALUE)
    public void decVote(@RequestParam Long id) {
        auth  = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        User currentUser = userService.getByName(userName);
        LocalTime currentTime = LocalTime.now();
        if(currentTime.isBefore(TIME_FOR_VOTE)){
            currentUser.setVote(false);
            userService.update(currentUser);
            Place incPlace = placeService.get(id);
            incPlace.decVote();
            placeService.update(incPlace);
            wasIncredId.set(0);
        }else{
            currentUser.setCanVote(false);
            userService.update(currentUser);
        }

    }
}
