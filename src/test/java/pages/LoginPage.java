package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginBtn  = By.id("login-button");

    public LoginPage open(String url) {
        driver().get(url);
        return this;
    }

    public InventoryPage loginAs(String user, String pass) {
        driver().findElement(username).sendKeys(user);
        driver().findElement(password).sendKeys(pass);
        driver().findElement(loginBtn).click();
        return new InventoryPage();
    }
}

