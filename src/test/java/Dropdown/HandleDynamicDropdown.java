package Dropdown;

import Initialization.Init;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandleDynamicDropdown extends Init {
    public static void main(String[] args) throws InterruptedException {
        // Create an object and initialize WebDriver
        HandleDynamicDropdown test = new HandleDynamicDropdown();
        test.setup();

        // Navigate to the demo page
        test.driver.navigate().to("https://techydevs.com/demos/themes/html/listhub-demo/listhub/index.html");
        // Create an explicit wait with a timeout of 30 seconds
        WebDriverWait wait = new WebDriverWait(test.driver, Duration.ofSeconds(30));
        // Wait until the loading overlay disappears before interacting with the page
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader-container")));

        // Locate and click the country dropdown to display the search input
        WebElement selectCountryElement = test.driver.findElement(By.xpath("//*[contains(text(), \"Select a " +
                "Country\")]/ancestor::div[contains(@class, \"main-search-input-item\")]"));
        selectCountryElement.click();

        // Locate the search input inside the dropdown
        WebElement inputCountryElement = test.driver.findElement(By.xpath("//*[contains(text(), \"Select a Country\")" +
                "]/ancestor::div[contains(@class, \"chosen-container\")]//input"));
        // Enter the desired country name
        inputCountryElement.sendKeys("Vietnam");

        // Create an Actions object to perform keyboard actions
        Actions actions = new Actions(test.driver);
        // Press ENTER to select the highlighted option
        // build() creates the action sequence
        // perform() executes the action
        actions.sendKeys(Keys.ENTER).build().perform();

        // Pause for observation
        Thread.sleep(3000);
        // Close the browser and end the WebDriver session
        test.tearDown();
    }
}
