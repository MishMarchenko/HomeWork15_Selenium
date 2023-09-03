package api.steps;

import api.config.BaseRequestSpecification;
import api.config.BaseResponseSpecification;
import api.config.Request;
import api.dto.request.AddBookUserIdBuilder;
import api.dto.response.GetUserWithBookResponseBuilder;
import api.dto.response.UsersBooksResponseBuilder;
import api.endpoints.Endpoints;
import api.utils.Utils;

import static api.utils.Utils.fromJson;
import static api.utils.Utils.toJson;

public class UserBookStoreSteps extends Request {
    BaseRequestSpecification baseRequest = new BaseRequestSpecification();
    BaseResponseSpecification baseResponse = new BaseResponseSpecification();


    public UsersBooksResponseBuilder addBook(AddBookUserIdBuilder book){
        var response = post(baseRequest.requestBook(), toJson(book), Endpoints.BOOK.getValue(), baseResponse.BOOK_ADDED_SUCCESS())
                .extract()
                .body()
                .asString();
        return Utils.fromJson(response, UsersBooksResponseBuilder.class);
    }

    public GetUserWithBookResponseBuilder getUser(){
        var response = get(baseRequest.requestWithToken(), Endpoints.USER.getValue(),"193f3d20-7993-43a7-8ed3-09f13c1a6363",
                baseResponse.OK()).extract().body().asString();
        return fromJson(response, GetUserWithBookResponseBuilder.class);
    }
}
