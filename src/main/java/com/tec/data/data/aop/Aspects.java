package com.tec.data.data.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect   
@Component
public class Aspects {

    
    @Before("pointCut()")
    public void before() {
        System.out.println("Before");
    }
    
    @Pointcut(value = "execution(public * com.tec.data.data.controller.Controller.*(..))")
    private void pointCut() {
            
    }
}
