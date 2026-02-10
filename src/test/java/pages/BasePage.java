package pages;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver() {
        return DriverFactory.getDriver();
    }
}

