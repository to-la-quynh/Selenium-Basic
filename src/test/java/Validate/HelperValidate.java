package Validate;

import org.openqa.selenium.WebElement;

public class HelperValidate {
    public void checkText(WebElement element, String expectedText) {
        if(element.getText().equals(expectedText)) {
            System.out.println(expectedText + " displayed correctly.");
        }else {
            System.out.println(expectedText + " didn't display correctly.");
        }
    }

    public boolean checkTextTrueFalse(WebElement element, String expectedText) {
        return element.getText().equals(expectedText);
    }
}
