package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebDriverSample_2 {
    public static void main(String[] args) throws InterruptedException {
        // Initialize Chrome browser
        WebDriver driver = new ChromeDriver();

        // Set implicit wait to 20 seconds
        // Selenium will wait up to 20 seconds when locating elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Maximize browser window
        driver.manage().window().maximize();

        // Navigate to the DemoQA Frames page
        driver.get("https://demoqa.com/frames");

        // Switch to the iframe with id/name "frame1"
        // Elements inside this frame cannot be accessed
        // until the driver switches to it.
        driver.switchTo().frame("frame1");

        // Locate the heading element inside the iframe
        WebElement h1 = driver.findElement(By.xpath("//h1[@id=\"sampleHeading\"][1]"));
        // Print the heading text to the console
        System.out.println(h1.getText());

        // Wait for page to load completely
        Thread.sleep(2000);

        // Close the current browser window
        driver.close();
    }
}
