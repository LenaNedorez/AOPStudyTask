package com.example.MyBookShopApp.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class BooksRestApiControllerArgExceptionAspect {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Pointcut(value = "@annotation(com.example.MyBookShopApp.annotations.ArgExceptionCatchable)")
    public void booksRestApiControllerArgExceptionPointcut(){}

    @AfterThrowing(pointcut = "args(input) && booksRestApiControllerArgExceptionPointcut()", throwing = "ex")
    public void booksRestApiControllerArgExceptionAdvice (JoinPoint joinPoint, String input, Exception ex){
        logger.info(joinPoint.getTarget().getClass().getSimpleName() + " was called, string input was: "
                    + input + ", caused exception: " + ex.getLocalizedMessage());
    }
}
