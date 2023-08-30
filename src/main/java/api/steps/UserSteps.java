package api.steps;


import api.config.BaseRequestSpecification;
import api.config.BaseResponseSpecification;
import api.config.Request;
import api.dto.request.UserBuilder;
import api.dto.response.GetUserResponseBuilder;
import api.dto.response.UserResponseBuilder;
import api.endpoints.Endpoints;
import api.endpoints.Schemas;
import api.utils.Utils;
import io.restassured.response.Response;

import static api.utils.Utils.toJson;


public class UserSteps extends Request {
    BaseRequestSpecification baseRequest = new BaseRequestSpecification();
    BaseResponseSpecification baseResponse = new BaseResponseSpecification();

    public UserResponseBuilder createUser(UserBuilder user){
        var response = post(baseRequest.request(),toJson(user), Endpoints.CREATE_USER.getValue(), baseResponse.OK(),
                Schemas.CREATE_USER_SCHEMA.getValue())
                .extract()
                .body()
                .asString();

        return Utils.fromJson(response, UserResponseBuilder.class);
    }
    public Response getUser(UserBuilder user, String username){
        return get(baseRequest.request(), Endpoints.USER_WITH_PARAM.getValue(), username);
    }
    public GetUserResponseBuilder getUser(String username){
        var response = get(baseRequest.request(), Endpoints.USER_WITH_PARAM.getValue(), username, baseResponse.OK(),
                Schemas.GET_USER_SCHEMA.getValue())
                .extract()
                .body()
                .asString();
        return Utils.fromJson(response, GetUserResponseBuilder.class);
    }
    public UserResponseBuilder changeUser(UserBuilder user){
        var response = put(baseRequest.request(), toJson(user), Endpoints.USER_WITH_PARAM.getValue(), user.getUsername(),
                baseResponse.OK())
                .extract()
                .body()
                .asString();
        return Utils.fromJson(response, UserResponseBuilder.class);
    }
}
