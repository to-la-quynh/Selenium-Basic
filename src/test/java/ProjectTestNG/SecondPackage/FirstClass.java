package ProjectTestNG.SecondPackage;

import org.testng.annotations.Test;

public class FirstClass {
    @Test
    public void firstMethod() {
        System.out.println("First Method of First Class in Second Package");
    }

    @Test
    public void secondMethod() {
        System.out.println("Second Method of First Class in Second Package");
    }
}
