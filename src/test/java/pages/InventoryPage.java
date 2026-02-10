package pages;

import org.openqa.selenium.By;

public class InventoryPage extends BasePage {
    private final By title = By.cssSelector(".title");

    public boolean isLoaded() {
        return driver().findElement(title).getText().equalsIgnoreCase("Products");
    }
}

