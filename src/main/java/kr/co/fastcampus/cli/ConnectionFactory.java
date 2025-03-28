package kr.co.fastcampus.cli;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class ConnectionFactory {
    private String driverClass;
    private String url;
    private String user;
    private String password;
    @Getter
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

    public void init() throws Exception {
        log.info("init");
        this.connection = createConnection();
    }

    public void destroy() throws Exception {
        log.info("destroy");
        if (connection != null) {
            this.connection.close();
        }
    }
}
