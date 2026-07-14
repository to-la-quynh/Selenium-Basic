package ProjectTestNG.AlertPopupIFrame;

import ProjectTestNG.Annotation.BaseTest1;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleAlert extends BaseTest1 {
    /**
     * ============================================================
     * Test Case 1:
     * Verify that a simple alert is displayed correctly and can be accepted.
     * ============================================================
     */
    @Test(priority = 1)
    public void verifySimpleAlert() throws InterruptedException {
        // Navigate to the Alerts page
        driver.get("https://demoqa.com/alerts");

        // Click the button to display the simple alert
        WebElement btn_alert = driver.findElement(By.id("alertButton"));
        btn_alert.click();

        //Switch the driver focus to the alert
        Alert alert = driver.switchTo().alert();

        //Get and print the alert message
        String alertText = alert.getText();
        System.out.println(alertText);

        //Accept the alert (Click OK)
        alert.accept();

        //Pause for observation
        Thread.sleep(2000);
    }

    /**
     * ============================================================
     * Test Case 2:
     * Verify that a prompt alert accepts user input successfully.
     * ============================================================
     */
    @Test(priority = 2)
    public void verifyPromptAlert() throws InterruptedException {
        //Navigate to the Alerts page
        driver.get("https://demoqa.com/alerts");

        //Click the button to display the prompt alert
        WebElement btn_prompt = driver.findElement(By.id("promtButton"));
        btn_prompt.click();

        //Switch the driver focus to the prompt alert
        Alert prompt = driver.switchTo().alert();

        //Get and print the prompt message
        String promptText = prompt.getText();
        System.out.println(promptText);

        //Enter text into the prompt
        String text = "test alert";
        prompt.sendKeys(text);

        //Accept the prompt
        prompt.accept();

        //Verify that the entered text is displayed correctly
        String promptResult = driver.findElement(By.id("promptResult")).getText();
        Assert.assertTrue(promptResult.contains(text), "Prompt result does not contain the entered text.");

        // Pause for observation
        Thread.sleep(2000);
    }

    /**
     * ============================================================
     * Test Case 3:
     * Verify that the confirmation alert can be dismissed.
     * ============================================================
     */
    @Test(priority = 3)
    public void verifyConfirmAlert() throws InterruptedException {
        // Navigate to the Alerts page
        driver.get("https://demoqa.com/alerts");

        // Click the button to display the confirmation alert
        WebElement btn_confirm = driver.findElement(By.xpath("//button[@id=\"confirmButton\"]"));
        btn_confirm.click();

        // Switch the driver focus to the confirmation alert
        Alert confirm = driver.switchTo().alert();

        // Get and print the confirmation message
        String cancelText = confirm.getText();
        System.out.println(cancelText);

        // Dismiss (click Cancel) the alert
        confirm.dismiss();

        // Verify that the cancel action is reflected on the page
        String confirmResult = driver.findElement(By.id("confirmResult")).getText();
        Assert.assertTrue(confirmResult.contains("You selected Cancel"), "Confirmation dialog was not dismissed successfully.");

        // Pause for observation
        Thread.sleep(2000);
    }
}
