package api;

import api.dto.request.AddBookUserIdBuilder;
import api.steps.UserBookStoreSteps;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class UserBookTest {
    UserBookStoreSteps user = new UserBookStoreSteps();
    @Test
    void getUserWithBook(){
        user.addBook(AddBookUserIdBuilder.builder()
                .userId("193f3d20-7993-43a7-8ed3-09f13c1a6363")
                .AddBookIsbnBuilder(new ArrayList<>())
                .build());

        var response = user.getUser();
        System.out.println(response);
    }
}
