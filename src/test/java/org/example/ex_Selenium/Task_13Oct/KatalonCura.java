package org.example.ex_Selenium.Task_13Oct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KatalonCura {

    @Test
    public void KatalonCuraTC(){

        /*Create a Selenium Script to verify the title for

        Open the Page - https://katalon-demo-cura.herokuapp.com/

        Verify the current URL, current title

        In the page source add a assertion that “CURA Healthcare Service” exist in the page. driver.pageSource() - String
        */

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/", "Current Url does not match");
        Assert.assertEquals(driver.getTitle(), "CURA Healthcare Service", "Title does not match");

        String pageSource = driver.getPageSource();
        Assert.assertEquals(pageSource.contains("CURA Healthcare Service"), true);

        driver.quit();

    }

}
