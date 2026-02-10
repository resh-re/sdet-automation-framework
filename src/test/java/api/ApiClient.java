package api;

import config.ConfigLoader;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public final class ApiClient {

    public static RequestSpecification base() {
        return RestAssured.given()
                .baseUri(ConfigLoader.get("apiBaseUrl"))
                .contentType("application/json");
    }

    private ApiClient() {}
}

