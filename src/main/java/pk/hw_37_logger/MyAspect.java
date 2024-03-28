package pk.hw_37_logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Before("execution(* pk.*(..))")
    public void beforeMethod() {
        System.out.println("Before method execution");
    }

}
