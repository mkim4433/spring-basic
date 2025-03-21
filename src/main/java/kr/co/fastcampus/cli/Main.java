package kr.co.fastcampus.cli;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Hello JAVA world!!");
        Dao dao = new Dao();
        dao.run();
    }
}
