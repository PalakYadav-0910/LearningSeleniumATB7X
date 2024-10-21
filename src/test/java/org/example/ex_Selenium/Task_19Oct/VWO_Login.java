package org.example.ex_Selenium.Task_19Oct;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VWO_Login {

    WebDriver driver = new ChromeDriver();

    @Description("Verify Login to - app.vwo.com with valid Username and password")
    @Test
    public void loginTC() throws InterruptedException {

        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();

        WebElement email = driver.findElement(By.id("login-username"));
        email.sendKeys("atb7x@gmail.com");

        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("Atb12345");

        WebElement signInBtn = driver.findElement(By.id("js-login-btn"));
        signInBtn.click();

        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/dashboard");

    }

    @Description("Verify name on Dashboard Page")
    @Test(dependsOnMethods = "loginTC")
    public void verifyName() throws InterruptedException {

        Thread.sleep(3000);
        Assert.assertEquals(driver.getPageSource().contains("xyz abc"), true);

        driver.quit();

    }
}
