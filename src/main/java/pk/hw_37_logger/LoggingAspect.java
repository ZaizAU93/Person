package pk.hw_37_logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

    @Before("execution(* pk.dao.PersonDAO.*(..))")
    public void before(JoinPoint joinPoint) {
        logger.info("Calling method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* pk.dao.PersonDAO.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Method " + joinPoint.getSignature().getName() + " returned: " + result);
    }

    @AfterThrowing(pointcut = "execution(* pk.dao.PersonDAO*(..))", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        logger.error("Exception in method " + joinPoint.getSignature().getName() + ": " + ex.getMessage());
    }
}