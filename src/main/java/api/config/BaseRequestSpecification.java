package api.config;

import static api.utils.Utils.getProperty;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseRequestSpecification {
    private final String APPLICATION_JSON = "application/json";
    private final String CONTENT_TYPE = "Content-type";
    private final String url =(String) getProperty("url");
    public RequestSpecification request(){
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setBasePath("v2/")
                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                .build();
    }
}
