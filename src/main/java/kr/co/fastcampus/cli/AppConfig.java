package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Slf4j
@Configuration
//@ComponentScan(basePackages = "kr.co.fastcampus.cli")
@Component
@PropertySource("classpath:application.properties")
public class AppConfig {
    public AppConfig() {
        log.info("App Config");
    }

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
