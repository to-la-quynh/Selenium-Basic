package FormControls;

import Initialization.Init;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HandleRadioButton extends Init {
    public static void main(String[] args) throws InterruptedException {
        // Create object and initialize WebDriver
        HandleRadioButton test = new HandleRadioButton();
        test.setup();
        // Navigate to Checkbox demo page
        test.driver.get("https://testing.qaautomationlabs.com/radio-button.php");

        /**
         * ============================================================
         * CASE 1:
         * Verify the default state of the "Male" radio button.
         * - If the "Male" radio button is not selected. click it.
         * - If it is already selected, print a confirmation message.
         * ============================================================
         */
        System.out.println("-----------CASE 1--------------");
        // Locate the "Male" radio button
        WebElement maleRadio = test.driver.findElement(By.xpath("//*[contains(text(), \"Click on button to get the " +
                "selected value.\")]/ancestor::*[@class=\"card-tools\"]//label[contains(text(), \"Male\")]/input"));
        // Verify whether the Male radio button is selected
        if (maleRadio.isSelected()) {
            System.out.println("Male radio button is selected");
        } else {
            System.out.println("Male radio button is not selected");
            // Select the Male radio button
            maleRadio.click();
            System.out.println("Male radio button is selected");
        }

        /**
         * ============================================================
         * CASE 2:
         * After selecting the "Male" radio button in Case 1. Verify the state of the "Female" radio button.
         * - If the "Female" radio button is selected, the test fails.
         * - Otherwise, the test passes.
         * ============================================================
         */
        System.out.println("-----------CASE 2--------------");
        // Locate the "Female" radio button
        WebElement femaleRadio = test.driver.findElement(By.xpath("//*[contains(text(), \"Click on button to get the " +
                "selected value.\")]/ancestor::*[@class=\"card-tools\"]//label[contains(text(), \"Female\")]/input"));
        // Verify that only one radio button is selected
        if (femaleRadio.isSelected()) {
            System.out.println("Female radio button is also selected. => the test fails");
        } else {
            System.out.println("Female radio button is not selected. => the test passes");
        }

        /**
         * ============================================================
         * CASE 3:
         * Verify the "Gender and Age" radio button group.
         * - Select the "Female" gender option.
         * - Select the "18-35" age group.
         * - Click the "Show Selected Values" button.
         * - Verify that the displayed result contains the selected
         *   age group ("18-35").
         * ============================================================
         */
        System.out.println("-----------CASE 3--------------");
        // Select the "Female" gender option
        WebElement femaleRadio1 = test.driver.findElement(By.xpath("//*[contains(text(), \"Gender and Age\")" +
                "]/ancestor::*[@class=\"card-tools\"]//label[contains(text(), \"Female\")]/input"));
        femaleRadio1.click();

        // Select the "18-35" age group
        WebElement radio1835 = test.driver.findElement(By.xpath("//label[contains(text(), \"18-35\")]/input"));
        radio1835.click();

        // Click the button to display the selected values
        WebElement showResultBtn = test.driver.findElement(By.xpath("//button[contains(text(), \"Show Selected Values\")]"));
        showResultBtn.click();

        // Get the displayed result
        WebElement result = test.driver.findElement(By.xpath("//*[@id=\"result3\"]"));
        String resultStr = result.getText();
        // Print the result
        System.out.println(resultStr);

        // Verify that the selected age group is displayed correctly
        if (resultStr.contains("18-35")) {
            System.out.println("The correct age group (18-35) is displayed.");
        } else {
            System.out.println("The selected age group is displayed incorrectly.");
        }

        // Pause for observation
        Thread.sleep(2000);
        // Close browser
        test.tearDown();
    }
}
