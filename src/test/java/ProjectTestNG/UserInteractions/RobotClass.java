package ProjectTestNG.UserInteractions;

import ProjectTestNG.Annotation.BaseTest1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotClass extends BaseTest1 {
    /**
     * ============================================================
     * Test Case:
     * Demonstrate how to use Java Robot class to simulate
     * keyboard actions for entering login information.
     * ============================================================
     */
    @Test
    public void inputData() throws AWTException, InterruptedException {
        // Navigate to Smart OTP login page
        driver.get("https://smartotp.llq.vn/");

        // Locate and focus on the username input field
        WebElement input_username = driver.findElement(By.id("username"));
        input_username.click();

        // Create Robot object to simulate keyboard actions
        Robot robot = new Robot();

        // Enter username "linhbm" character by character
        robot.keyPress(KeyEvent.VK_L);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_N);
        robot.keyPress(KeyEvent.VK_H);
        robot.keyPress(KeyEvent.VK_B);
        robot.keyPress(KeyEvent.VK_M);

        // Press TAB to move focus to the password field
        robot.keyPress(KeyEvent.VK_TAB);

        // Locate password field
        WebElement input_password = driver.findElement(By.id("password"));

        // Enter password using Selenium
        input_password.sendKeys("Abc@123");

        // Press ENTER to submit the login form
        robot.keyPress(KeyEvent.VK_ENTER);

        // Pause for observation
        Thread.sleep(2000);
    }
}
