package ProjectTestNG.AlertPopupIFrame;

import ProjectTestNG.Annotation.BaseTest1;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HandleiFrame extends BaseTest1 {
    @Test
    public void iFrameDemo() {
        driver.get("https://demoqa.com/nestedframes");

        // Count all iframe elements in the main page
        int frameTotal = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Total frame: " + frameTotal);

        // Switch to the parent frame
        driver.switchTo().frame("frame1");

        // Print the parent frame text
        System.out.println("Parent: "
                + driver.findElement(By.tagName("body")).getText());

        // Switch to the child frame inside the parent frame
        driver.switchTo().frame(0);

        // Print the child frame text
        System.out.println("Child: "
                + driver.findElement(By.tagName("body")).getText());

        // Return to the main page
        driver.switchTo().defaultContent();
    }
}
