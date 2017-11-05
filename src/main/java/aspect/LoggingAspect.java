package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(public * model.dao.PersonDao.* (..))")
    public void logBefore(JoinPoint joinPoint) {

        System.out.println("Before executing method...");
        System.out.println("Method: " + joinPoint.getSignature().getName());
        System.out.println("------------------");
    }

    @After("execution(public * model.dao.PersonDao.*(..))")
    public void logAfter(JoinPoint joinPoint){

        System.out.println("After executing method...");
        System.out.println("Method: " + joinPoint.getSignature().getName());
        System.out.println("------------------");
    }
}
