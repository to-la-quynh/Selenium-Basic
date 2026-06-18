package WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebElementSample {
    public static void main(String[] args) throws InterruptedException {
        // Initialize Chrome browser
        WebDriver driver = new ChromeDriver();

        // Set implicit wait to 10 seconds
        // Selenium will wait up to 10 seconds when locating elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Maximize browser window
        driver.manage().window().maximize();

        //Navigate to Smart OTP website
        driver.get("https://smartotp.llq.vn");

        Thread.sleep(2000);

        // Locate username textbox by ID
        // Clear existing value and enter username
        WebElement username = driver.findElement(By.id("username"));
        username.clear();
        username.sendKeys("linhbm");

        // Locate password textbox by ID
        // Clear existing value and enter password
        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys("Abc@123");

        // Locate Login button by XPath using visible text
        // Click to sign in
        WebElement btn_dangNhap = driver.findElement(By.xpath("//button[contains(text(), \"Đăng nhập\")]"));
        btn_dangNhap.click();
        Thread.sleep(2000);

        // Locate "Smart OTP" menu by Link Text
        // Navigate to Smart OTP module
        WebElement link_smartOTP = driver.findElement(By.linkText("Smart OTP"));
        link_smartOTP.click();
        Thread.sleep(2000);

        // Locate "Tạo mã kích hoạt" menu by Link Text
        // Navigate to Activation Code page
        WebElement link_taoMaKichHoat = driver.findElement(By.linkText("Tạo mã kích hoạt"));
        link_taoMaKichHoat.click();
        Thread.sleep(2000);

        // Verify that user has successfully navigated
        // to the Activation Code page
        WebElement header_taoMaKichHoat = driver.findElement(By.xpath("//h5[contains(text(), \"Tạo mã kích hoạt\")]"));
        boolean isInTaoMaKichHoatPage = header_taoMaKichHoat.isDisplayed();
        if(isInTaoMaKichHoatPage){
            System.out.println("Đã đến trang Tạo mã kích hoạt");
        }

        // Locate "Tạo mã kích hoạt" button
        WebElement btn_taoMaKichHoat = driver.findElement(By.xpath("//button[contains(text(), \"Tạo mã kích hoạt\")]"));
        // Verify whether the button is enabled before clicking
        if(btn_taoMaKichHoat.isEnabled()){
            // Click the button when it is enabled
            btn_taoMaKichHoat.click();
        }else{
            // Print message if button is disabled
            System.out.println("Không click vào button Tạo mã kích hoạt được");
        }

        Thread.sleep(2000);
//        driver.quit(); // Close all browser windows and end WebDriver session
        // Close current browser window
        driver.close();
    }
}
