package driver;

import config.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class DriverFactory {
    private static final ThreadLocal<WebDriver> TL_DRIVER = new ThreadLocal<>();

    public static void initDriver() {
        String browser = ConfigLoader.get("browser").toUpperCase();
        boolean headless = Boolean.parseBoolean(ConfigLoader.get("headless"));

        WebDriver driver;
        BrowserType type = BrowserType.valueOf(browser);

        switch (type) {
            case CHROME -> {
                ChromeOptions options = new ChromeOptions();
                if (headless) options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");
                driver = new ChromeDriver(options);
            }
            case FIREFOX -> driver = new FirefoxDriver();
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        TL_DRIVER.set(driver);
    }

    public static WebDriver getDriver() {
        return TL_DRIVER.get();
    }

    public static void quitDriver() {
        WebDriver d = TL_DRIVER.get();
        if (d != null) {
            d.quit();
            TL_DRIVER.remove();
        }
    }

    private DriverFactory() {}
}
