package pk.hw_37_logger;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {
    @Bean
    public MyAspect myAspect() {
        return new MyAspect();
    }

}
