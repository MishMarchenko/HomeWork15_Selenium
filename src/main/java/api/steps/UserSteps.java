package api.steps;


import api.config.BaseRequestSpecification;
import api.config.BaseResponseSpecification;
import api.config.Request;
import api.dto.request.UserBuilder;
import api.dto.response.GetUserResponseBuilder;
import api.dto.response.UserCreateResponseBuilder;
import api.endpoints.Endpoints;
import api.utils.Utils;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static api.utils.Utils.toJson;


public class UserSteps extends Request {
    BaseRequestSpecification baseRequest = new BaseRequestSpecification();
    BaseResponseSpecification baseResponse = new BaseResponseSpecification();

    public UserCreateResponseBuilder createUser(UserBuilder user){
        var response = post(baseRequest.request(),toJson(user), Endpoints.CREATE_USER.getValue(), baseResponse.OK())
                .extract()
                .body()
                .asString();
        return Utils.fromJson(response, UserCreateResponseBuilder.class);
    }
    public Response getUser(UserBuilder user, String username){
        return get(baseRequest.request(), Endpoints.GET_USER.getValue(), username);
    }
    public GetUserResponseBuilder getUser(String username){
        var response = get(baseRequest.request(), Endpoints.GET_USER.getValue(), username, baseResponse.OK())
                .extract()
                .body()
                .asString();
        return Utils.fromJson(response, GetUserResponseBuilder.class);
    }
}
