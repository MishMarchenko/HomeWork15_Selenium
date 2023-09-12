package db;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class AddAndDeleteUserTest extends BaseTest{
    String userName;
    @Test
    public void getDeletedUserName(){
                try {
            statement.executeUpdate("INSERT INTO users (name, age) VALUES ('Alice', 27)");
            System.out.println("The person Alice added successfully");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        try {
            statement.execute("DELETE FROM users WHERE name = 'Alice'");
            System.out.println("The person Alice deleted successfully");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM users WHERE name like 'Alice'");
            while (rs.next()) {
                userName = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println(userName);
                System.out.println(age);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        assertThat(userName).as("Something went wrong").isEqualTo(null);
    }
}
