package kr.co.fastcampus.cli;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        logger.info("Hello JAVA world!!");

        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
        Dao2 dao2 = context.getBean("dao2", Dao2.class);
        dao2.run();
    }
}
