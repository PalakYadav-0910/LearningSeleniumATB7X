package org.example.ex_Selenium.ex_12102024;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Selenium03 {

    @Test
    public void test_001() {
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://sdet.live");
        driver.quit();
    }

}
