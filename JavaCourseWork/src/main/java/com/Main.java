package main.java.com;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class Main {
    public static void main(String[] args) {
        Connection connection = DB_Connect.getConnection();
        SpringApplication.run(Main.class, args);
    }
}
 