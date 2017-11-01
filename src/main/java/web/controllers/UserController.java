package web.controllers;

import model.Place;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.PlaceService;
import service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController //by default returns JSON
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {

        return new ArrayList<>();
    }
    @GetMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(@PathVariable("uuid") Long uuid) {
        return new User();
    }
    @PostMapping(value = "/update",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> update(
                            @RequestParam (required=false)String uid,
                            @RequestParam(required=false)Long uuuid,
                            @RequestParam String uname,
                            @RequestParam String uemail,
                            @RequestParam (required=false) String en,
                            @RequestParam (required=false) String uisvote,
                            @RequestParam (required=false) String ucanvote
                             ) {


        User upUser = new User();
        if(uid.isEmpty()){


        }else{

        }


        String name = uname;
        if(name.isEmpty()){
            name = "Empty";
        }
        String email = uemail;
        if(email.isEmpty()){
            email = "empty";
        }

        if(en == null){
            en = "false";
        }else{
            en="true";
        }

        if (uisvote == null){
            uisvote = "false";
        }else{
            uisvote = "true";
        }

        if(ucanvote == null){
            ucanvote = "false";
        }else{
            ucanvote = "true";
        }

        boolean enabled = Boolean.parseBoolean(en);
        boolean isVote = Boolean.parseBoolean(uisvote);
        boolean canVote = Boolean.parseBoolean(ucanvote);


        upUser.setEmail(email);
        upUser.setEnabled(enabled);
        upUser.setVote(isVote);
        upUser.setCanVote(canVote);


        return new ArrayList<>();
    }
    @DeleteMapping
    public void delete(@RequestParam Long userUuid) {


    }
}
