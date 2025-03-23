package kr.co.fastcampus.cli;

import lombok.Getter;
import org.springframework.beans.factory.InitializingBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
public class ConnectionFactory implements InitializingBean {
    private String driverClass;
    private String url;
    private String user;
    private String password;
    private Connection connection = null;

    public ConnectionFactory(String driverClass, String url, String user, String password) {
        this.driverClass = driverClass;
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection createConnection() throws SQLException {
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return DriverManager.getConnection(this.url, this.user, this.password);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.connection = createConnection();
    }
}
