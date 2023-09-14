package api.config;

import static api.utils.Utils.getApiProperty;
import static api.utils.Utils.toJson;

import api.dto.request.UserBookBuilders.UserRequestBuilder;
import api.endpoints.Endpoints;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseRequestSpecification {
    private final String APPLICATION_JSON = "application/json";
    private final String CONTENT_TYPE = "Content-type";
    private final String url =(String) getApiProperty("url");
    private final String url_account = (String) getApiProperty("url_account");
    private final String url_book = (String) getApiProperty("url_book");
    private final Request request = new Request();
    private final BaseResponseSpecification response = new BaseResponseSpecification();

    public String getToken(){
        return request.post(requestAccount(), toJson(new UserRequestBuilder("Mikho123", "123qweQWE!")),
                Endpoints.GET_TOKEN.getValue(), response.OK()).extract().body().path("token");
    }
    public RequestSpecification request(){
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setBasePath("v2")
                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                .build();
    }
    public RequestSpecification requestAccount(){
        return new RequestSpecBuilder()
                .setBaseUri(url_account)
                .setBasePath("v1")
                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                .build();
    }
    public RequestSpecification requestWithToken(){
        return new RequestSpecBuilder()
                .setBaseUri(url_account)
                .setBasePath("v1")
                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                .addHeader("Authorization", "Bearer " + getToken())
                .build();
    }
    public RequestSpecification requestBookWithToken(){
        return new RequestSpecBuilder()
                .setBaseUri(url_book)
                .setBasePath("v1")
                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                .addHeader("Authorization", "Bearer " + getToken())
                .build();
    }
}
