package api.config;

import static api.utils.Utils.getProperty;
import static api.utils.Utils.toJson;

import api.dto.request.UserRequestBuilder;
import api.endpoints.Endpoints;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseRequestSpecification {
    private final String APPLICATION_JSON = "application/json";
    private final String CONTENT_TYPE = "Content-type";
    private final String url =(String) getProperty("url");
    private final String url_book_store = (String) getProperty("url_book_store");
    private final String account = "Account/";
    private final String BOOK_STORE = "BookStore/";
    private final Request request = new Request();
    private final BaseResponseSpecification response = new BaseResponseSpecification();

    public String getToken(){
        return request.post(requestBook(), toJson(new UserRequestBuilder("Mikho123", "123qweQWE!")),
                Endpoints.GET_TOKEN.getValue(), response.OK()).extract().body().path("token");
    }
    public RequestSpecification request(){
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setBasePath("v2")
                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                .build();
    }
    public RequestSpecification requestBook(){
        return new RequestSpecBuilder()
                .setBaseUri(url_book_store)
                .setBasePath("v1")
                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                .build();
    }
    public RequestSpecification requestWithToken(){
        return new RequestSpecBuilder()
                .setBaseUri(url_book_store)
                .setBasePath("v1")
                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                .addHeader("Authorization", "Bearer " + getToken())
                .build();
    }
}
