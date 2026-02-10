package api;

import io.restassured.response.Response;

public final class ReqResUsersApi {

    public static Response getUsers(int page) {
        return ApiClient.base()
                .queryParam("page", page)
                .when()
                .get("/api/users");
    }

    private ReqResUsersApi() {}
}

