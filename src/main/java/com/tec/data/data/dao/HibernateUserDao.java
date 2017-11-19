package com.tec.data.data.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tec.data.data.model.User;

@Repository
public class HibernateUserDao implements UserDaoInterface {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUser(String login) {
        String hql = "FROM User U WHERE U.login = :login ";
        return (User) sessionFactory.getCurrentSession().createQuery(hql).setParameter("login", login).getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAllUsers() {
        String hql = "FROM User U WHERE U.login = :login ";
        return sessionFactory.getCurrentSession().createQuery(hql).list();
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void saveUser(User user) {
        sessionFactory.getCurrentSession().persist(user);
    }

    @Override
    public void removeUser(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

}
