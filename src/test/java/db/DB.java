package db;

import java.sql.*;

public class DB {
    private final static String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private final static String USER = "Mikho";
    private final static String PASS = "qwer1608QWER";
    static Statement statement = null;

    public static void main(String[] args) throws SQLException {
        System.out.println("Test connection to Driver");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e){
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

        if (connection != null){
            System.out.println("We successfully get connection");
        }else{
            System.out.println("Fail to get connection");
        }

        //SQL SELECT
        statement = connection.createStatement();
//        try {
//
//            ResultSet rs = statement.executeQuery("SELECT * FROM users WHERE name LIKE 'Alice'");
//
//            while (rs.next()) {
//                String username = rs.getString("name");
//                int age = rs.getInt("age");
//
//                System.out.println(username);
//                System.out.println(age);
//            }
//        } catch (SQLException e){
//            e.printStackTrace();
//        }

        //SQL INSERT

//        try {
//            statement.executeUpdate("INSERT INTO users (name, age) VALUES ('Alice', 27)");
//            System.out.println("The person Alice added successfully");
//        } catch (SQLException e){
//            throw new RuntimeException(e);
//        }

        //SQL UPDATE

//        try {
//            statement.execute("UPDATE users SET name = 'MikhoBro' WHERE name = 'Peter'");
//            System.out.println("The person updated successfully");
//        } catch (SQLException e){
//            throw new RuntimeException(e);
//        }


        //SQL DELETE

        try {
            statement.execute("DELETE FROM users WHERE name = 'Alice'");
            System.out.println("The person Alice deleted successfully");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
