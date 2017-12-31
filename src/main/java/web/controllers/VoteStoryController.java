package web.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;
import service.VoteStoryService;
import transferObjects.VoteStoryTO;

import java.util.List;

@RestController
@RequestMapping(value = "admin/voteStory")
public class VoteStoryController {


   @Autowired
    UserService userService;
   @Autowired
    VoteStoryService voteStoryService;
    @GetMapping(value = "/getData", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VoteStoryTO> get() {
       return voteStoryService.getAllVoteStoryTOs();


    }

}
