package api.config;

import api.dto.request.UserRequestBuilder;
import api.endpoints.Endpoints;

import static api.utils.Utils.toJson;

public class Auth extends Request{
    BaseRequestSpecification request = new BaseRequestSpecification();
    BaseResponseSpecification response = new BaseResponseSpecification();
    public String getToken(){
        return post(request.requestBook(), toJson(new UserRequestBuilder("Mikho", "123qweQWE!")),
                Endpoints.GET_TOKEN.getValue(), response.OK()).extract().body().path("token");
    }
}
