package api.steps;

import api.config.BaseRequestSpecification;
import api.config.BaseResponseSpecification;
import api.config.Request;
import api.dto.response.Root;
import api.endpoints.Endpoints;

import static api.utils.Utils.fromJson;

public class UserBookStoreSteps extends Request {
    BaseRequestSpecification baseRequest = new BaseRequestSpecification();
    BaseResponseSpecification baseResponse = new BaseResponseSpecification();

    public Root getUser(){
        var response = get(baseRequest.requestWithToken(), Endpoints.USER.getValue(),"193f3d20-7993-43a7-8ed3-09f13c1a6363",
                baseResponse.OK()).extract().body().asString();
        return fromJson(response, Root.class);
    }
}
