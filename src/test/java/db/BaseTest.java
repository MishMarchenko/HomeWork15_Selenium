package db;

import org.testng.annotations.BeforeMethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static db.Utils.getDbProperty;

public class BaseTest {
    private final String DB_URL =(String) getDbProperty("DB_URL");
    private final String USER = (String) getDbProperty("USERNAME");
    private final String PASS = (String) getDbProperty("PASSWORD");
    static Statement statement = null;
    @BeforeMethod
    public  void before() throws SQLException {
        System.out.println("Test connection to Driver");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("error connect to driver");
            throw new RuntimeException(e);
        }
        System.out.println("We successfully connected to driver");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Fail to get connection");
            throw new RuntimeException(e);
        }
        if (connection != null) {
            System.out.println("We successfully get connection");
        } else {
            System.out.println("Fail to get connection");
        }
        statement = connection.createStatement();
    }
}