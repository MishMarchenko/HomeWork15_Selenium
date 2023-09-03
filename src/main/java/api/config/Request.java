package api.config;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Request {
    public Response post(RequestSpecification request, String body, String endpoint){
        return given()
                .spec(request)
                .body(body)
                .post(endpoint);
    }
    public ValidatableResponse post(RequestSpecification request, String body, String endpoint, ResponseSpecification response){
        return given()
                .spec(request)
                .body(body)
                .post(endpoint)
                .then()
                .log().all()
                .spec(response);
    }
    public ValidatableResponse post(RequestSpecification request, String body, String endpoint, ResponseSpecification response,
                                    String path){
        return given()
                .spec(request)
                .body(body)
                .post(endpoint)
                .then()
                .spec(response)
                .body(matchesJsonSchemaInClasspath(path));
    }
    public Response get(RequestSpecification request, String endpoint, String username){
        return given()
                .spec(request)
                .get(endpoint + username);
    }
    public ValidatableResponse get(RequestSpecification request, String endpoint, String param, ResponseSpecification response){
        return given()
                .spec(request)
                .get(endpoint + param)
                .then()
                .log().all()
                .spec(response);
    }
    public ValidatableResponse get(RequestSpecification request, String endpoint, String username, ResponseSpecification response,
                                   String path){
        return given()
                .spec(request)
                .get(endpoint + username)
                .then()
                .spec(response)
                .body(matchesJsonSchemaInClasspath(path));
    }
    public ValidatableResponse put(RequestSpecification request, String body, String endpoint, String param,
                        ResponseSpecification response){
        return given()
                .spec(request)
                .body(body)
                .put(endpoint + param)
                .then()
                .spec(response);
    }
    public ValidatableResponse put(RequestSpecification request, String body, String endpoint, String param,
                                   ResponseSpecification response, String path){
        return given()
                .spec(request)
                .body(body)
                .put(endpoint + param)
                .then()
                .spec(response)
                .body(matchesJsonSchemaInClasspath(path));
    }
    public ValidatableResponse delete(RequestSpecification request, String endpoint, String param, ResponseSpecification response){
        return given()
                .spec(request)
                .delete(endpoint + param)
                .then()
                .spec(response);
    }
    public ValidatableResponse getNotFound(RequestSpecification request, String endpoint, String username, ResponseSpecification response,
                                   String path){
        return given()
                .spec(request)
                .get(endpoint + username)
                .then()
                .spec(response)
                .body(matchesJsonSchemaInClasspath(path));
    }
}
