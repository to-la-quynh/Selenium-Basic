package ProjectTestNG.AlertPopupIFrame;

import ProjectTestNG.Annotation.BaseTest1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class HandlePopupWindow extends BaseTest1 {
    /**
     * ============================================================
     * Test Case:
     * Verify that a new browser window can be opened and switched to.
     * ============================================================
     */
    @Test
    public void testHandlePopupWindow() {
        // Navigate to the Browser Windows demo page
        driver.get("https://demoqa.com/browser-windows");

        // Click the button to open a new browser window
        WebElement btn_newWindow = driver.findElement(By.id("windowButton"));
        btn_newWindow.click();

        // Get the ID of the current (parent) window
        String mainWindow = driver.getWindowHandle();
        System.out.println("Main window: " + mainWindow);

        // Get all opened window IDs
        Set<String> allWindows = driver.getWindowHandles();

        // Iterate through all window handles
        for (String window : allWindows) {
            // Switch to the child window
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                System.out.println("Switched to the child window.");
                // Get and print the heading displayed in the child window
                String heading = driver.findElement(By.xpath("//h1")).getText();
                System.out.println(heading);

                // Verify the heading text
                Assert.assertEquals(
                        heading,
                        "This is a sample page",
                        "Incorrect page title in child window."
                );
                driver.close();
            } else {
                System.out.println("Trùng");
            }
        }
        // Switch back to the parent window
        driver.switchTo().window(mainWindow);
    }
}
