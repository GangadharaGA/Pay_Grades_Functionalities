package Utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserUtils {
	
	
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            // Set the path to the ChromeDriver executable
            System.setProperty("webdriver.chrome.driver", "D:/WebDrivers/GoogleChrome/chromedriver-win64/chromedriver.exe");

            // Create ChromeOptions object to set browser properties
            ChromeOptions options = new ChromeOptions();

            // Example: Setting browser window size
            options.addArguments("window-size=1200x800");

            // Create WebDriver instance with ChromeOptions
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

