package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.Lifecycle;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;

@Slf4j
public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        logger.info("로그 찍음 - Hello JAVA world!!");
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
//        ConnectionFactory factory = context.getBean(ConnectionFactory.class);
//        Connection connection = factory.getConnection();
//        log.info("connection : " + (connection != null));
        Lifecycle lifecycle = context.getBean(Lifecycle.class);
        log.info(">> 1 " + lifecycle.isRunning());
        context.close();
        log.info(">> 2 " + lifecycle.isRunning());
//        Dao2 dao2 = context.getBean("dao2", Dao2.class);
//        dao2.run();
    }
}
