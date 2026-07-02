package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class WebDriverSample {
    public static void main(String[] args) throws InterruptedException {
        // Initialize Chrome browser
        WebDriver driver = new ChromeDriver();

        // Set implicit wait to 20 seconds
        // Selenium will wait up to 20 seconds when locating elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Maximize browser window
        driver.manage().window().maximize();

        // Switch browser to full screen mode
        driver.manage().window().fullscreen();

        //Navigate to Orange HRM website
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        // Wait for page to load completely
        Thread.sleep(2000);

        // Find all input elements inside the login form
        List<WebElement> inputList = driver.findElements(By.xpath("//form//input"));
        // Iterate through each input element
        // and print its "name" attribute
        for (WebElement inputElement : inputList) {
            System.out.println(inputElement.getAttribute("name"));
        }

        // Wait a few seconds before closing browser
        Thread.sleep(4000);
        // Print completion message
        System.out.println("Chạy hoàn tất");
        // Close all browser windows and end WebDriver session
//        driver.quit();
        // Close current browser window
        driver.close();
    }
}
