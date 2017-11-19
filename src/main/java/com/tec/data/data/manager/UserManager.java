package com.tec.data.data.manager;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.tec.data.data.dao.UserDaoInterface;
import com.tec.data.data.model.Notification;
import com.tec.data.data.model.Notification.Type;
import com.tec.data.data.model.User;

@Service
@Transactional
public class UserManager {

    @Resource(name = "hibernateUserDao")
    private UserDaoInterface userDao;

    public User createUser(String login, String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);

        userDao.saveUser(user);

        return user;
    }

    public User login(String login, String password) {

        User user = userDao.getUser(login);
        if (user != null && user.getPassword().equals(password))
            return user;
        return null;
    }

    public User changePassword(String login, String oldPassword, String newPassword) {
        User user = userDao.getUser(login);
        if (user != null && user.getPassword().equals(oldPassword)) {
            user.setPassword(newPassword);
            userDao.updateUser(user);
            return user;
        }
        return null;
    }

    public User remove(String login, String password) {
        User user = userDao.getUser(login);
        if (user != null && user.getPassword().equals(password)) {
            userDao.removeUser(user);
            return user;
        }
        
        return null;
    }

    public User sendMessege(String login, String message, Type type) {
        User user = userDao.getUser(login);
        if (user == null) {
            user = new User(-1, "not found", "not found");
            return user;
        }
        Notification notification = new Notification();
        notification.setType(type);
        notification.setMassage(message);
        notification.setUserId(user.getId());
        notification.setUser(user);
        
        user.getNotificationSet().add(notification);
        
        userDao.updateUser(user);
        
        return user;
    }

    
    
    
}
