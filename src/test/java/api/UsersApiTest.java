package tests.api;

import base.BaseTest;
import api.ReqResUsersApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UsersApiTest extends BaseTest {

    @Test(groups = {"smoke", "api"})
    public void getUsers_page2_shouldReturn200_andNonEmptyData() {
        Response res = ReqResUsersApi.getUsers(2);

        Assert.assertEquals(res.statusCode(), 200);
        Assert.assertTrue(res.jsonPath().getList("data").size() > 0, "data should not be empty");
    }
}

