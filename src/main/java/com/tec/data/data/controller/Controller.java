package com.tec.data.data.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.tec.data.data.manager.UserManager;
import com.tec.data.data.model.Notification.Type;
import com.tec.data.data.model.User;

@Component
public class Controller {

    @Resource(name = "userManager")
    private UserManager userManager;

    public User login(String login, String password) {
        User user = userManager.login(login, password);
        System.out.println("User entered : " + user);
        return user;
    }

    public User registration(String login, String password) {
        User user = userManager.createUser(login, password);
        System.out.println("User created : " + user);
        return user;
    }

    public User changePassword(String login, String oldPassword, String newPassword) {
        User user = userManager.changePassword(login, oldPassword, newPassword);
        System.out.println("Password changed " + user);
        return user;
    }

    public User deRegistration(String login, String password) {
        User user = userManager.remove(login, password);
        System.out.println("User removed " + user);
        return user;
    }

    public User sendMessage(String login, String message, Type type) {
        User user = userManager.sendMessege(login, message, type);
        System.out.println("Message sended to " + user.getNotificationSet().stream()
                .filter(e -> e.getMassage().equals(message)).findAny().orElse(null));
        System.out.println("User " + user);
        return user;
    }
}
