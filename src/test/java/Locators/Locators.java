package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
    public static void main(String[] args) throws InterruptedException {
        // Initialize Chrome browser
        WebDriver driver = new ChromeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Navigate to SmartOTP website
        driver.get("https://smartotp.llq.vn/");

        // Dừng chương trình 2 giây để quan sát trình duyệt
        Thread.sleep(2000);

        /*
         * Locate element by ID
         * ID is usually the fastest and most reliable locator
         */
        WebElement username = driver.findElement(By.id("username"));
        username.clear();
        username.sendKeys("linhbm");

        /*
         * Locate element by ID
         * Enter password into password textbox
         */
        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys("Abc@123");

        /*
         * Locate element by XPath
         * Find login button based on its displayed text
         */
        WebElement btn_dangNhap = driver.findElement(By.xpath("//button[contains(text(), \"Đăng nhập\")]"));
        btn_dangNhap.click();

        Thread.sleep(2000);

        /*
         * Locate element by Link Text
         * Click the hyperlink with exact visible text "Smart OTP"
         */
        WebElement link_smartOTP = driver.findElement(By.linkText("Smart OTP"));
        link_smartOTP.click();
        Thread.sleep(2000);

        /*
         * Locate element by Tag Name
         * Find the first <a> element on the page
         */
        WebElement tagnameA = driver.findElement(By.tagName("a"));
        String text = tagnameA.getText();
        System.out.println(text);

        /*
         * Locate element by Link Text
         * Click the hyperlink named "Đề nghị"
         */
        WebElement link_deNghi = driver.findElement(By.linkText("Đề nghị"));
        link_deNghi.click();
        Thread.sleep(2000);

        /*
         * Locate element by CSS Selector
         * Select input element whose type attribute equals 'text'
         */
        WebElement account = driver.findElement(By.cssSelector("[type='text']"));
        account.sendKeys("12");

        Thread.sleep(2000);
        // Close current browser window
        driver.close();
    }
}
