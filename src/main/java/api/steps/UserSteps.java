package api.steps;


import api.config.BaseRequestSpecification;
import api.config.BaseResponseSpecification;
import api.config.Request;
import api.dto.UserBuilder;
import api.endpoints.Endpoints;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static api.utils.Utils.toJson;


public class UserSteps extends Request {
    BaseRequestSpecification baseRequest = new BaseRequestSpecification();
    BaseResponseSpecification baseResponse = new BaseResponseSpecification();

    public ValidatableResponse createUser(UserBuilder user){
        return post(baseRequest.request(),toJson(user), Endpoints.CREATE_USER.getValue(), baseResponse.OK());
    }
    public Response getUser(UserBuilder user){
        return get(baseRequest.request(), Endpoints.GET_USER.getValue());
    }
}
