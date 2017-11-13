package util;

import model.Role;
import model.User;
import transferObjects.UserTO;

import java.util.Collections;
import java.util.HashSet;

public class UserUtil {


    public static User createNewFromTo(UserTO newUser) {
        return new User(null, newUser.getName(), newUser.getEmail().toLowerCase(), newUser.getPassword(), Collections.singleton(Role.ROLE_USER));
    }

    public static UserTO asTo(User user) {
        return new UserTO(user.getId(), user.getName(), user.getEmail(), user.getPassword());
    }

    public static User updateFromTo(User user, UserTO userTo) {
        user.setName(userTo.getName());
        user.setEmail(userTo.getEmail().toLowerCase());
        user.setPassword(userTo.getPassword());
        return user;
    }

    public static User prepareToSave(User user) {
        user.setPassword(PasswordUtil.encode(user.getPassword()));
        user.setEmail(user.getEmail().toLowerCase());
        return user;
    }
}
