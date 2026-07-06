package Dropdown;

import Initialization.Init;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandleStaticDropdown extends Init {
    public static void main(String[] args) throws InterruptedException {
        HandleStaticDropdown test = new HandleStaticDropdown();
        test.setup();
        // Navigate to Dropdown demo page
        test.driver.get("https://testing.qaautomationlabs.com/dropdown.php");

        /**
         * ============================================================
         * CASE 1:
         * Verify the static dropdown.
         * - Select options using different Select methods.
         * - Verify the selected value.
         * - Check whether the dropdown supports multiple selection.
         * - Print all available options.
         * ============================================================
         */

        //Locate the dropdown element
        WebElement optionDropdown = test.driver.findElement(By.id("fruitDropdown"));

        //Create a select object to interact with the dropdown
        Select optionSelect = new Select(optionDropdown);

        //Locate the result message displayed after selecting an option
        WebElement result = test.driver.findElement(By.xpath("//*[@id=\"result\"]"));

        //Select an option by value
        optionSelect.selectByValue("Orange");
        System.out.println(result.getText());

        //Select an option by index (index started from 0)
        optionSelect.selectByIndex(1);
        System.out.println(result.getText());

        //Select an option by visible text
        optionSelect.selectByVisibleText("Banana");
        System.out.println(result.getText());

        //Check whether this dropdown allows multiple selections
        if (optionSelect.isMultiple()) {
            System.out.println("This is a multi-selected dropdown");
        } else {
            System.out.println("This is a single-selected dropdown");
        }

        //Print the total number of options
        System.out.println("Selected option: " + optionSelect.getOptions().size());

        //Get the currently selected option
        System.out.println(optionSelect.getFirstSelectedOption().getText());
        //Verify that the selected option is displayed correctly
        if (result.getText().contains(optionSelect.getFirstSelectedOption().getText())) {
            System.out.println("The correct option is selected.");
        } else {
            System.out.println("Incorrect option is selected.");
        }

        // Get all options from the dropdown
        List<WebElement> getAllOptions = optionSelect.getOptions();
        System.out.println("Danh sách options:");
        // Print all option values
        for (WebElement option : getAllOptions) {
            // Print visible text
//            System.out.println(option.getText());
            // Print value attribute
            System.out.println(option.getAttribute("value"));
        }

        // Pause for observation
        Thread.sleep(2000);
        // Close browser
        test.tearDown();
    }
}
