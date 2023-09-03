package api;

import api.steps.UserBookStoreSteps;
import org.testng.annotations.Test;

public class UserBookTest {
    UserBookStoreSteps user = new UserBookStoreSteps();
    @Test
    void getUserWithBook(){
        var response = user.getUser();
        System.out.println(response);
    }
}
