package api;

import api.steps.UserBookStoreSteps;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class UserBookTest {
    UserBookStoreSteps user = new UserBookStoreSteps();
    @Test
    void getUserWithBook(){
        user.addBook();
    var response = user.getUser();
        assertThat(response.getBooks().get(0).getTitle())
                .as("Title isn't equal")
                .isEqualTo("Learning JavaScript Design Patterns");
    }
    @AfterTest
    void deleteBook(){
        user.deleteBook();
    }
}
