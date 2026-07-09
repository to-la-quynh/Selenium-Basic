package ProjectTestNG.Assert;

import ProjectTestNG.Annotation.BaseTest1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AssertSample extends BaseTest1 {
    /**
     * ============================================================
     * Test Case:
     * Verify that a new Smart OTP activation proposal can be created
     * successfully and appears in the proposal list.
     * ============================================================
     */
    @Test
    public void createActivationProposal() {
        // Navigate to the Smart OTP login page
        driver.get("https://smartotp.llq.vn/");

        /**
         * ============================================================
         * Step 1: Log in to the Smart OTP system.
         * ============================================================
         */
        //Enter username
        WebElement input_username = driver.findElement(By.id("username"));
        input_username.sendKeys("linhbm");

        // Enter password
        WebElement input_password = driver.findElement(By.id("password"));
        input_password.sendKeys("Abc@123");

        // Click the Login button
        WebElement button_login = driver.findElement(By.xpath("//button[contains(text(), \"Đăng nhập\")]"));
        button_login.click();

        /**
         * ============================================================
         * Step 2: Open the Smart OTP activation request page.
         * ============================================================
         */
        // Click the "Smart OTP" menu
        WebElement link_smartOTP = driver.findElement(By.linkText("Smart OTP"));
        link_smartOTP.click();

        // Click "Tạo mã kích hoạt"
        WebElement link_taoMa = driver.findElement(By.linkText("Tạo mã kích hoạt"));
        link_taoMa.click();

        /**
         * ============================================================
         * Step 3: Create a new activation proposal.
         * ============================================================
         */
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

        /**
         * ============================================================
         * Step 4: Verify the created proposal.
         * ============================================================
         */
        // Click "Đề nghị"
        WebElement link_deNghi = driver.findElement(By.linkText("Đề nghị"));
        link_deNghi.click();

        // Search using the generated account ID
        WebElement input_accountSearch = driver.findElement(By.name("accountIdLike"));
        input_accountSearch.sendKeys(account);

        // Verify that the created proposal exists in the result table
        Assert.assertTrue(driver.findElement(By.xpath("//tbody//tr")).isDisplayed(), "The newly created activation proposal was not found." +
                "mới");
    }
}
