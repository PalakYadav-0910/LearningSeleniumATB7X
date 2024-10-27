package org.example.ex_Selenium.Task_20Oct;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VWOLogin_VerifyDashboard {

    @Description("Login with Valid Credentials and verify text Dashboard on Dashboard Page")
    @Test
    public void verifyDashboard() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://app.vwo.com/#/login");

        Thread.sleep(3000);

        WebElement email = driver.findElement(By.id("login-username"));
        email.sendKeys("atb7x@gmail.com");

        WebElement pswd = driver.findElement(By.id("login-password"));
        pswd.sendKeys("Atb12345");

        WebElement signInBtn = driver.findElement(By.xpath("//span[text()='Sign in']"));
        signInBtn.click();

        Thread.sleep(6000);

        String dashboardText = driver.findElement(By.xpath("//h1[text()='Dashboard']")).getText();
        Assert.assertEquals(dashboardText, "Dashboard", "Page does not contain Dashboard text");

        Thread.sleep(2000);

        driver.quit();

    }
}
