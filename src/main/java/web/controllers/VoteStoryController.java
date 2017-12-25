package web.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

@RestController
@RequestMapping(value = "admin/voteStory")
public class VoteStoryController {


   @Autowired
    UserService userService;
    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public void get() {

    }
}
