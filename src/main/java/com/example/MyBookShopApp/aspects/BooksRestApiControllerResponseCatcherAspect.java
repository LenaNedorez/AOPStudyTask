package com.example.MyBookShopApp.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class BooksRestApiControllerResponseCatcherAspect {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Pointcut(value = "execution(* books*()) && within(com.example.MyBookShopApp.controllers.BooksRestApiController))")
    public void booksRestApiControllerArgCatcherPointcut(){}

    @AfterReturning(pointcut = "booksRestApiControllerArgCatcherPointcut()", returning = "response")
    public void booksRestApiControllerArgCatcherAdvice(JoinPoint joinPoint, ResponseEntity response){
            logger.info(joinPoint.getTarget().getClass().getSimpleName() + "was invoked" +
                        "returning ResponseEntity" + response.toString());
    }
}
