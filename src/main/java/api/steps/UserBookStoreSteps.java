package api.steps;

import api.config.BaseRequestSpecification;
import api.config.BaseResponseSpecification;
import api.config.Request;
import api.dto.request.UserBook.AddBookUserIdBuilder;
import api.dto.request.UserBook.CollectionOfIsbn;
import api.dto.response.UserBook.BookIsbnResponseBuilder;
import api.dto.response.UserBook.GetUserWithBookResponseBuilder;
import api.endpoints.Endpoints;
import api.utils.Utils;

import java.util.List;

import static api.utils.Utils.fromJson;
import static api.utils.Utils.toJson;

public class UserBookStoreSteps extends Request {
    BaseRequestSpecification baseRequest = new BaseRequestSpecification();
    BaseResponseSpecification baseResponse = new BaseResponseSpecification();


    public BookIsbnResponseBuilder addBook(){
        var response = post(baseRequest.requestBookWithToken(), toJson(new AddBookUserIdBuilder("193f3d20-7993-43a7-8ed3-09f13c1a6363",
                        List.of(new CollectionOfIsbn("9781449331818")))),
                Endpoints.BOOK.getValue(), baseResponse.BOOK_ADDED_SUCCESS())
                .extract()
                .body()
                .asString();
        return Utils.fromJson(response, BookIsbnResponseBuilder.class);
    }

    public GetUserWithBookResponseBuilder getUser(){
        var response = get(baseRequest.requestWithToken(), Endpoints.USER.getValue(),"193f3d20-7993-43a7-8ed3-09f13c1a6363",
                baseResponse.OK())
                .extract()
                .body()
                .asString();
        return fromJson(response, GetUserWithBookResponseBuilder.class);
    }
}
