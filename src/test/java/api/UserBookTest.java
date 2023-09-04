package api;

import api.dto.request.UserBook.AddBookUserIdBuilder;
import api.dto.request.UserBook.CollectionOfIsbn;
import api.dto.response.UserBook.BookIsbnResponseBuilder;
import api.steps.UserBookStoreSteps;
import org.testng.annotations.Test;



public class UserBookTest {
    UserBookStoreSteps user = new UserBookStoreSteps();
    BookIsbnResponseBuilder collect = new BookIsbnResponseBuilder();
    @Test
    void getUserWithBook(){
        user.addBook(AddBookUserIdBuilder.builder()
                .userId("193f3d20-7993-43a7-8ed3-09f13c1a6363")
                .build());

        var response = user.getUser();
        System.out.println(response);
    }
}
