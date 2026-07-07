package FormControls;

import Initialization.Init;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HandleCheckbox extends Init {

    public static void main(String[] args) throws InterruptedException {
        // Create object and initialize WebDriver
        HandleCheckbox init = new HandleCheckbox();
        init.setup();
        // Navigate to Checkbox demo page
        init.driver.get("https://testing.qaautomationlabs.com/checkbox.php");

        /**
         * ============================================================
         * CASE 1:
         * Verify the "Check Me" checkbox.
         * - If it is already selected -> print a message.
         * - Otherwise -> select it and verify the success message.
         * ============================================================
         */
        // Locate the "Check Me" checkbox
        WebElement checkMe = init.driver.findElement(By.xpath("//*[text() = \"Single Checkbox Demo\"]/ancestor::div[@class=\"card-tools\"]//input[@id=\"myCheckbox\"]"));

        /// Check the current status of the checkbox
        if (checkMe.isSelected()) {
            System.out.println("Checkbox is selected");
        } else {
            // Select the checkbox
            checkMe.click();
            // Locate the success message
            WebElement msg = init.driver.findElement(By.xpath("//*[text() = \"Single Checkbox Demo\"]/ancestor::div[@class=\"card-tools\"]//div[@id=\"message\"]"));
            // Verify the message is displayed
            if (msg.isDisplayed()) {
                System.out.println(msg.getText());
            } else {
                System.out.println("Message is not displayed");
            }
        }

        /**
         * ============================================================
         * CASE 2:
         * Verify the "Check All" button.
         * - Click the button.
         * - Verify all checkboxes are selected.
         * ============================================================
         */
        // Locate the Check All button
        WebElement checkAllBtn = init.driver.findElement(By.id("toggleBtn"));
        // Verify the button text before clicking
        if (checkAllBtn.getText().equals("Check All")) {
            // Click the button
            checkAllBtn.click();
            // Get all checkboxes in the Multiple Checkbox section
            List<WebElement> checkboxList = init.driver.findElements(By.xpath("//*[text() = \"Multiple Checkbox Demo\"]/ancestor::div[@class=\"card-tools\"]//input[@type=\"checkbox\"]"));
            // Assume all checkboxes are selected
            boolean isSelected = true;
            // Verify every checkbox is selected
            for (WebElement checkbox : checkboxList) {
                if (!checkbox.isSelected()) {
                    isSelected = false;
                    break;
                }
            }
            // Print verification result
            if (isSelected) {
                System.out.println("Checkboxes are selected.");
            } else {
                System.out.println("Some checkboxes are not selected.");
            }
        } else {
            System.out.println("The button is not in 'Check All' state.");
        }

        /**
         * ============================================================
         * CASE 3:
         * Verify the "Uncheck All" button.
         * - Click the button.
         * - Verify all checkboxes are deselected.
         * ============================================================
         */
        // Locate the "Uncheck All" button
        WebElement uncheckAllBtn = init.driver.findElement(By.id("toggleBtn"));
        // Verify the button text before clicking
        if (uncheckAllBtn.getText().equals("Uncheck All")) {
            // Click the button
            uncheckAllBtn.click();
            // Get all checkboxes in the Multiple Checkbox section
            List<WebElement> checkboxList = init.driver.findElements(By.xpath("//*[text() = \"Multiple Checkbox " +
                    "Demo\"]/ancestor::div[@class=\"card-tools\"]//input[@type=\"checkbox\"]"));
            // Assume all checkboxes are deselected
            boolean isDeselected = true;
            // Verify that no checkbox remains selected
            for (WebElement checkbox : checkboxList) {
                if (checkbox.isSelected()) {
                    isDeselected = false;
                    break;
                }
            }
            // Print verification result
            if (!isDeselected) {
                System.out.println("Checkboxes are not deselected.");
            } else {
                System.out.println("checkboxes are deselected.");
            }
        } else {
            System.out.println("The button is not in 'Uncheck All' state.");
        }

        // Pause for observation
        Thread.sleep(2000);
        // Close browser
        init.tearDown();
    }
}
