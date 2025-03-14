package kr.co.fastcampus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        logger.info("Hello JAVA world!!");

        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("org.h2.Driver");
//            String url = "jdbc:h2:~/test;MODE=MySQL;";
            String url = "jdbc:h2:mem:test;MODE=MySQL;";
            connection = DriverManager.getConnection(url, "sa", "");
            statement = connection.createStatement();

            connection.setAutoCommit(false);

            statement.execute("create table member(id int auto_increment, username varchar(255) not null, password varchar(255) not null, primary key(id))");
            statement.executeUpdate("insert into member(username, password) values('mkim', '1234')");

            ResultSet resultSet = statement.executeQuery("select id, username, password from member");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                logger.info("id: " + id + ", username: " + username + ", password: " + password);
            }

            connection.commit();
            
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            if (connection != null) {
                connection.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
