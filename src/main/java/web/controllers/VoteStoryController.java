package web.controllers;


import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

@RestController
@RequestMapping(value = "admin/voteStory")
public class VoteStoryController {

   private Authentication auth;
   @Autowired
    UserService userService;
    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public void get() {
      auth  = SecurityContextHolder.getContext().getAuthentication();

      String userName = auth.getName();

      User currentUser = userService.getByName(userName);
    }
}
