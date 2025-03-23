package kr.co.fastcampus.cli;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    @Qualifier("b1")
    public B b1() {
        return new B();
    }

    @Bean
    @Qualifier("b2")
    public B b2() {
        return new B();
    }
}
