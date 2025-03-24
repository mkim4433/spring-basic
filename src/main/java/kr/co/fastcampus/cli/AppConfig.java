package kr.co.fastcampus.cli;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {
    @Bean
    @Qualifier("b1")
    public B appBeanB1() {
        return new B();
    }

    @Bean
    @Qualifier("b2")
    public B appBeanB2() {
        return new B();
    }
}
