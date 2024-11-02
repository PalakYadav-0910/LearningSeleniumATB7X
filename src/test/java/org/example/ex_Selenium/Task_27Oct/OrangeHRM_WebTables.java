package org.example.ex_Selenium.Task_27Oct;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHRM_WebTables {

    private static final Logger log = LoggerFactory.getLogger(OrangeHRM_WebTables.class);
    WebDriver driver;

    @BeforeTest
    public void openBrowser() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.addArguments("--guest");
        driver = new ChromeDriver(chromeOptions);

    }

    @Description("Login to Orange HRM and Find the First Terminated Employee and " +
            "Click on the Delete icon ()")
    @Test
    public void handlingWebTables() {

        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("admin");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("Hacker@4321");

        WebElement loginBtn = driver.findElement(By.xpath("//button[text()= ' Login ']"));
        loginBtn.click();

        WebElement webTable = driver.findElement(By.xpath("//div[@class='orangehrm-container']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", webTable);

        int rowCount = driver.findElements(By.xpath("//div[contains(@class,'oxd-table-row--clickable')]")).size();

        for (int i = 0; i < rowCount; i++) {

            WebElement row = driver.findElements(By.xpath("//div[contains(@class,'oxd-table-row--clickable')]")).get(i);
            if (row.getText().contains("Terminated")) {
                WebElement deleteBtn = driver.findElement(By.xpath("//i[@class='oxd-icon bi-trash']"));
                deleteBtn.click();
                break;
            }
        }
    }


    @AfterTest
    public void closeBrowser() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }
}
