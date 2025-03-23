package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
public class Dao2 {
    private Connection connection;

    public Dao2(Connection connection) {
        this.connection = connection;
    }

    void init() {
        log.info("dao2 -- init");
    }

    void destroy() {
        log.info("dao2 -- destroy");
    }

    public void run() throws SQLException {
        var statement = connection.createStatement();
        connection.setAutoCommit(false);
        statement.execute("create table member(id int auto_increment, username varchar(255) not null, password varchar(255) not null, primary key(id))");
        try {
            statement.executeUpdate("insert into member(username, password) values('mkim', '1234')");
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
        }

        var resultSet = statement.executeQuery("select id, username, password from member");
        while (resultSet.next()) {
            var member = new Member(resultSet);
            log.info(member.toString());
        }
    }
}
