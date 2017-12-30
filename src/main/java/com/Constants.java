package com;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.UserService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.time.LocalTime.of;
@Component
public class Constants {
    @Autowired
    UserService userService;

    public static final LocalTime TIME_FOR_VOTE = of(11, 0);
    public static final LocalDate TIME_OF_LAUNCH = LocalDate.now();
    public void defaultMethod(){
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(() -> {
            List<User> userList = userService.getAll();
            userList.forEach(user -> {
                user.setVote(false);
                user.setCanVote(true);
                userService.update(user);
            });

        }, 0, 1, TimeUnit.DAYS);

    }

}
