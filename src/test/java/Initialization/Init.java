package Initialization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Init {
    //Declare the WebDriver instance
    protected WebDriver driver;

    /**
     * Initialize the Chrome browser and configure Webdriver settings
     */
    public void setup() {
        //Lauch Chrome driver
        driver = new ChromeDriver();
        //Wait up to 30 seconds for a page to finish loading
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        //Set implicit wait to 20 seconds for locating elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Maximize the browser window
        driver.manage().window().maximize();
    }

    /**
     * Close the browser and end the Webdriver session
     */
    public void tearDown() {
        //Close all browser windows and terminate the Webdriver session
        if (driver != null) {
            driver.quit();
        }
    }
}
