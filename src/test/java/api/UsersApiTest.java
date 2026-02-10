package api;

import base.BaseTest;
import api.ReqResUsersApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UsersApiTest extends BaseTest {

    @Test(groups = {"smoke", "api"})
public void getResources_shouldReturn200() {
    Response res = ApiClient.base()
            .when()
            .get("/api/unknown");

    Assert.assertEquals(res.statusCode(), 200);
    Assert.assertTrue(res.jsonPath().getList("data").size() > 0);
}
}

