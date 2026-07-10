package ProjectTestNG.UserInteractions;

import ProjectTestNG.Annotation.BaseTest1;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsClass extends BaseTest1 {
    /**
     * ============================================================
     * Test Case:
     * Demonstrate basic mouse and keyboard actions using
     * Selenium Actions class.
     * ============================================================
     */
    @Test
    public void testAction() throws InterruptedException {
        // Navigate to Smart OTP login page
        driver.get("https://smartotp.llq.vn/");

        // Locate the username input field
        WebElement input_username = driver.findElement(By.id("username"));

        // Create an instance of the Actions class
        Actions action = new Actions(driver);

        // Click inside the username textbox
        action.click(input_username);

        // Type the username
        action.sendKeys(input_username, "linhbm");

        // Press TAB to move focus to the password field
        action.sendKeys(Keys.TAB);

        // Enter password into the currently focused field
        action.sendKeys("Abc@123");

        // Press ENTER to submit the login form
        action.sendKeys(Keys.ENTER);

        // Execute all keyboard actions
        action.build().perform();

        // Locate the page header after successful login
        WebElement headerHomePage = driver.findElement(By.xpath("//h5[contains(text(), \"Kích hoạt Smart OTP\")]"));

        // Double-click the page header
        action.doubleClick(headerHomePage).build().perform();

        // Right-click the current mouse position
        action.contextClick().build().perform();

        // Pause for observation
        Thread.sleep(2000);
    }
}
