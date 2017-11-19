package com.tec.data.data.context;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;

import com.tec.data.data.controller.Controller;
import com.tec.data.data.dao.HibernateUserDao;
import com.tec.data.data.dao.UserDaoInterface;
import com.tec.data.data.manager.UserManager;
import com.tec.data.data.util.HibernateUtil;

public class Context {
    
    private static final Map<Class, Object> context = new HashMap<>();
    
    static {
        context.put(Controller.class, new Controller());
        context.put(UserManager.class, new UserManager());
        context.put(UserDaoInterface.class, new HibernateUserDao());
        context.put(Session.class, HibernateUtil.getSessionFactory().openSession());
    }
    
    @SuppressWarnings("unchecked")
    public static<T> T getBeen(Class<T> clazz){
        
        T instance = (T) context.get(clazz);
        if (clazz == Session.class) return instance;
        
        for (Field f : instance.getClass().getDeclaredFields()) {
            try {
                f.setAccessible(true);
                f.set(instance, getBeen(f.getType()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        
        return instance;
    }

}
