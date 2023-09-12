package db;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AddAndUpdateUserTest extends BaseTest {
    String userName;
    @Test
        public void GetUpdatedUserName(){
            try {
                statement.executeUpdate("INSERT INTO users (name, age) VALUES ('Ben', 27)");
                System.out.println("The person Ben added successfully");
            } catch (SQLException e){
                throw new RuntimeException(e);
            }
                try {
            statement.execute("UPDATE users SET name = 'Dan' WHERE name = 'Ben'");
            System.out.println("The person Ben updated successfully");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM users WHERE name like 'Dan'");
            while (rs.next()) {
                userName = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println(userName);
                System.out.println(age);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        assertThat(userName).as("Something went wrong").isEqualTo("Dan");
    }
}
