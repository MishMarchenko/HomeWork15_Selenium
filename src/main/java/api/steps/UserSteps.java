package api.steps;


import api.config.BaseRequestSpecification;
import api.config.BaseResponseSpecification;
import api.config.Request;
import api.dto.request.UserBuilder;
import api.dto.response.User.CreateUserResponseBuilder;
import api.dto.response.User.GetUserResponseBuilder;
import api.dto.response.User.ChangeUserResponseBuilder;
import api.dto.response.User.DeleteUserResponseBuilder;
import api.dto.response.User.GetNotFoundUserResponseBuilder;
import api.endpoints.Endpoints;
import api.endpoints.Schemas;
import api.utils.Utils;
import io.restassured.response.Response;

import static api.utils.Utils.toJson;


public class UserSteps extends Request {
    BaseRequestSpecification baseRequest = new BaseRequestSpecification();
    BaseResponseSpecification baseResponse = new BaseResponseSpecification();

    public CreateUserResponseBuilder createUser(UserBuilder user){
        var response = post(baseRequest.request(),toJson(user), Endpoints.CREATE_USER.getValue(), baseResponse.OK(),
                Schemas.CREATE_USER_SCHEMA.getValue())
                .extract()
                .body()
                .asString();

        return Utils.fromJson(response, CreateUserResponseBuilder.class);
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
    public ChangeUserResponseBuilder changeUser(UserBuilder user){
        var response = put(baseRequest.request(), toJson(user), Endpoints.USER_WITH_PARAM.getValue(), user.getUsername(),
                baseResponse.OK())
                .extract()
                .body()
                .asString();
        return Utils.fromJson(response, ChangeUserResponseBuilder.class);
    }
    public ChangeUserResponseBuilder changeUserWithSchema(UserBuilder user){
        var response = put(baseRequest.request(), toJson(user), Endpoints.USER_WITH_PARAM.getValue(), user.getUsername(),
                baseResponse.OK(), Schemas.CHANGE_USER_SCHEMA.getValue())
                .extract()
                .body()
                .asString();
        return Utils.fromJson(response, ChangeUserResponseBuilder.class);
    }
    public DeleteUserResponseBuilder deleteUser(String username){
        var response = delete(baseRequest.request(), Endpoints.USER_WITH_PARAM.getValue(), username, baseResponse.OK())
                .extract()
                .body()
                .asString();
        return Utils.fromJson(response, DeleteUserResponseBuilder.class);
    }
    public GetNotFoundUserResponseBuilder getNotFoundUser(String username){
        var response = getNotFound(baseRequest.request(), Endpoints.USER_WITH_PARAM.getValue(), username, baseResponse.NOT_FOUND(),
                Schemas.GET_DELETED_USER_SCHEMA.getValue())
                .extract()
                .body()
                .asString();
        return Utils.fromJson(response, GetNotFoundUserResponseBuilder.class);
    }
}
