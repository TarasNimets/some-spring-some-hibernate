package com.tec.data.data.dao;

import java.util.List;

import com.tec.data.data.model.User;

public interface UserDaoInterface {

    User getUser(String login);

    List<User> getAllUsers();

    void updateUser(User user);

    void saveUser(User user);

    void removeUser(User user);

}
