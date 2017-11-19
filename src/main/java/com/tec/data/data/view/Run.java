package com.tec.data.data.view;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tec.data.data.config.AppConfig;
import com.tec.data.data.controller.Controller;
import com.tec.data.data.model.Notification.Type;

public class Run {

    public static void main(String[] args) throws SQLException {

//        ApplicationContext context = new ClassPathXmlApplicationContext("spring-contex.xml");
//        UserDao userDao = context.getBean(UserDao.class);
//
//        List<User> users = userDao.selectAllUser();
//
//        System.out.println(users);

//        Controller controller = Context.getBeen(Controller.class);

//        controller.login("taras", "pass");
//        controller.registration("taras", "12345");
//        controller.changePassword("taras", "12345", "pass");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        Controller controller = context.getBean(Controller.class);

//        controller.login("taras", "pass");
        controller.sendMessage("tequillas", "tequillas", Type.WARNING);
    }
}
