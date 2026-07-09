package ProjectTestNG.Annotation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoginPageSmartOTP extends BaseTest1 {
    /**
     * ============================================================
     * Test Case 1:
     * Verify that the user can log in to the Smart OTP system.
     * ============================================================
     */
    @Test(priority = 1)
    public void loginToSmartOTP() {
        // Navigate to the Smart OTP login page
        driver.get("https://smartotp.llq.vn/");

        //Enter username
        WebElement input_username = driver.findElement(By.id("username"));
        input_username.sendKeys("linhbm");

        // Enter password
        WebElement input_password = driver.findElement(By.id("password"));
        input_password.sendKeys("Abc@123");

        // Click the Login button
        WebElement button_login = driver.findElement(By.xpath("//button[contains(text(), \"Đăng nhập\")]"));
        button_login.click();

        // Verify that the Smart OTP dashboard is displayed after login
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), \"Kích hoạt Smart OTP\")]")).isDisplayed(), "Login failed.");
    }

    /**
     * ============================================================
     * Test Case 2:
     * Navigate to the Smart OTP feature.
     * ============================================================
     */
    @Test(priority = 2)
    public void navigateToSmartOTP() {
        // Click the "Smart OTP" menu
        WebElement link_smartOTP = driver.findElement(By.linkText("Smart OTP"));
        link_smartOTP.click();

        // Verify that the Smart OTP page is opened successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), \"Tạo mã kích hoạt\")]")).isDisplayed(),
                "Không vào trang SmartOTP khi đã click SmartOTP");
    }

    /**
     * ============================================================
     * Test Case 3:
     * Create a new Smart OTP activation request.
     * ============================================================
     */
    @Test(priority = 3)
    public void createActivationProposal() {
        // Click "Tạo mã kích hoạt"
        WebElement link_deNghi = driver.findElement(By.linkText("Tạo mã kích hoạt"));
        link_deNghi.click();

        // Generate a unique account ID based on the current date and time to avoid duplicate account names during
        // test execution.
        // Format: yyyyMMddHHmmss
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
        //Get curent date time
        String account = LocalDateTime.now().format(formatter);

        System.out.println("Account: " + account);

        //Enter account
        WebElement input_account = driver.findElement(By.name("accountId"));
        input_account.sendKeys(account);

        //Enter phone number
        WebElement input_phoneNumber = driver.findElement(By.name("phoneNumber"));
        input_phoneNumber.sendKeys("0327651111");

        //Click Create button
        WebElement button_create = driver.findElement(By.xpath("//button[contains(text(), \"Tạo mã kích hoạt\")]"));
        button_create.click();

        // Verify that the success notification contains the expected message
        WebElement alert = driver.findElement(By.xpath("//div[contains(@class, \"alert\")]"));
        Assert.assertTrue(alert.isDisplayed(), "Success notification is not displayed.");
        Assert.assertTrue(alert.getText().contains("Tạo đề nghị tạo mã kích hoạt thành công"), "Activation request was not created successfully.");
    }

}
