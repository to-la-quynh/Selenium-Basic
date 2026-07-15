package ProjectTestNG.JavaScriptExecutor;

import ProjectTestNG.Annotation.BaseTest1;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class jsExecutor extends BaseTest1 {
    /**
     * ============================================================
     * Test Case 1:
     * Demonstrate how to execute JavaScript in Selenium.
     * - Click a button using JavaScript.
     * - Retrieve the page title.
     * - Retrieve the domain name.
     * ============================================================
     */
    @Test
    public void jsExecutorDemo() throws InterruptedException {
        // Cast WebDriver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Navigate to DemoQA Buttons page
        driver.get("https://demoqa.com/buttons");

        //Click on "Click Me" using JavaScript Executor
        WebElement btn_clickMe = driver.findElement(By.xpath("//button[text() = \"Click Me\"]"));
        js.executeScript("arguments[0].click()", btn_clickMe);

        //Get page title and domain using JavaScript Executor
        String title = js.executeScript("return document.title;").toString();
        System.out.println("Title: " + title);

        String domainName = js.executeScript("return document.domain").toString();
        System.out.println("Domain Name: " + domainName);

        Thread.sleep(2000);
    }

    /**
     * ============================================================
     * Test Case 2:
     * Demonstrate how to manipulate a checkbox using JavaScript.
     * - Set the checkbox state directly without calling click().
     * ============================================================
     */
    @Test
    public void jsExecutorDemo_checkbox() throws InterruptedException {
        //Cast WebDriver to JavaScriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Navigate to SeleniumBase demo page
        driver.get("https://seleniumbase.io/demo_page");

        //Check the checkbox by modifying its "checked" property
        js.executeScript("document.getElementById(\"checkBox1\").checked = true\n");

        Thread.sleep(2000);
    }
}
