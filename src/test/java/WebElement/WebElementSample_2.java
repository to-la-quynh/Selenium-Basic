package WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebElementSample_2 {
    public static void main(String[] args) throws InterruptedException {
        // Initialize Chrome browser
        WebDriver driver = new ChromeDriver();

        // Set implicit wait to 20 seconds
        // Selenium will wait up to 20 seconds when locating elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Maximize browser window
        driver.manage().window().maximize();

        //Navigate to Orange HRM website
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);

        // Get login credentials information displayed on the page using getText()
        String info = driver.findElement(By.xpath("//form/preceding-sibling::*")).getText();
        System.out.println("Thông tin đăng nhập: " + info);

        // Locate Username label and get its tag name using getTagName()
        WebElement tagNameElm = driver.findElement(By.xpath("//*[contains(text(), \"Username\")]"));
        String tagName = tagNameElm.getTagName();
        System.out.println("Tag name: " + tagName);

        // Get CSS property value of Username label
        String tagNameCSS = tagNameElm.getCssValue("color");
        System.out.println("Tag css: " + tagNameCSS);

        // Get class attribute value of Username label
        String classValue = tagNameElm.getAttribute("class");
        System.out.println("Class: " + classValue);

        // Get width and height of the Username label
        Dimension size = tagNameElm.getSize();
        System.out.println("Width: " + size.width);
        System.out.println("Height: " + size.height);

        // Enter username
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
        Thread.sleep(2000);
        // Enter password
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
        Thread.sleep(2000);
        // Click Login button
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        Thread.sleep(2000);
        // Navigate to My Info page
        driver.findElement((By.xpath("//span[normalize-space()='My Info']"))).click();
        Thread.sleep(2000);

//        driver.findElement((By.xpath("//button[contains(.,'Add')]"))).click();
        Thread.sleep(2000);
        // Locate Male radio button under Gender section
        WebElement statusEnabled = driver.findElement(By.xpath("//*[contains(text(),'Gender')]/parent::*/following-sibling::*//input[@value='1']"));
        // Check whether Male radio button is selected
        if (statusEnabled.isSelected()) {
            System.out.println(statusEnabled.isSelected());
            // Select Female radio button if Male is currently selected
            driver.findElement(By.xpath("//label[contains(.,'Female')]")).click();
        } else {
            System.out.println("Chưa được chọn");
        }

        Thread.sleep(4000);
        // Print completion message
        System.out.println("Chạy hoàn tất");

        //        driver.quit(); // Close all browser windows and end WebDriver session
        // Close current browser window
        driver.close();
    }
}
