package tests.ui;

import base.BaseTest;
import base.TestListener;
import config.ConfigLoader;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;

@Listeners(TestListener.class)
public class LoginUiTest extends BaseTest {

    @Test(groups = {"smoke", "ui"})
    public void validLogin_shouldLandOnProducts() {
        boolean loaded = new LoginPage()
                .open(ConfigLoader.get("baseUrl"))
                .loginAs("standard_user", "secret_sauce")
                .isLoaded();

        Assert.assertTrue(loaded, "Inventory page should load after login");
    }
}

