package web.controllers;

import model.Place;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.PlaceService;
import service.UserService;

import java.util.List;
import java.util.UUID;

@RestController //by default returns JSON
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    UserService service;
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {

        return service.getAll();
    }
    @GetMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(@PathVariable("uuid") String uuid) {
        return service.get(uuid);
    }
    @PostMapping(value = "/update",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> update(
                            @RequestParam (required=false)String uid,
                            @RequestParam(required=false)String uuuid,
                            @RequestParam String uname,
                            @RequestParam String uemail,
                            @RequestParam (required=false) String en,
                            @RequestParam (required=false) String uisvote,
                            @RequestParam (required=false) String ucanvote
                             ) {


        User upUser = new User();
        if(uid.isEmpty()){
           Integer nuid = service.getSize();
           upUser.setId(nuid);
        }else{
            upUser.setId(Integer.valueOf(uid));
        }

        if(uuuid.isEmpty()){
            uuuid = UUID.randomUUID().toString();
            upUser.setUuid(uuuid);
        } else{
            upUser = service.get(uuuid);
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

        upUser.setName(name);
        upUser.setEmail(email);
        upUser.setEnabled(enabled);
        upUser.setVote(isVote);
        upUser.setCanVote(canVote);

        service.update(upUser.getUuid(),upUser);
        return service.getAll();
    }
    @DeleteMapping
    public void delete(@RequestParam String userUuid) {
        service.delete(userUuid);

    }
}
