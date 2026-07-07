package Dropdown;

import Initialization.Init;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class HandleDynamicDropdown extends Init {
    public static void main(String[] args) throws InterruptedException {
        HandleDynamicDropdown test = new HandleDynamicDropdown();
        test.setup();

        test.driver.navigate().to("https://techydevs.com/demos/themes/html/listhub-demo/listhub/index.html");
        WebDriverWait wait = new WebDriverWait(test.driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader-container")));

        WebElement selectCountryElement = test.driver.findElement(By.xpath("//*[contains(text(), \"Select a " +
                "Country\")]/ancestor::div[contains(@class, \"main-search-input-item\")]"));
        selectCountryElement.click();

        WebElement inputCountryElement = test.driver.findElement(By.xpath("//*[contains(text(), \"Select a Country\")" +
                "]/ancestor::div[contains(@class, \"chosen-container\")]//input"));
        inputCountryElement.sendKeys("Vietnam");

        Actions actions = new Actions(test.driver);
        //Hamf build() để xây dựng hành động, hàm perform() để xác nhận ứng dụng đó
        actions.sendKeys(Keys.ENTER).build().perform();

        Thread.sleep(3000);
        test.tearDown();
    }
}
