package org.example.ex_Selenium.ex_02112024_Actions_Windows_Iframe;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Selenium48_Actions_P3 {

    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }

    @Description("Verify actions p3")
    @Test
    public void test_actions_p3() throws InterruptedException {

        driver.manage().window().maximize();
        String URL = "https://www.makemytrip.com/";

        driver.get(URL);
        driver.manage().window().maximize();

        //Wait for the popup to come and click the x icon
        // //span[@data-cy = 'closeModal']

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Wait until the element is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy = 'closeModal']")));

        driver.findElement(By.xpath("//span[@data-cy = 'closeModal']")).click();

        WebElement fromCity = driver.findElement(By.id("fromCity"));
        Thread.sleep(3000);

        Actions actions = new Actions(driver);
        /*actions.moveToElement(fromCity).click().sendKeys("New Delhi").build().perform();

        List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']/li"));

        for(WebElement e:list){
            if(e.getText().contains("New Delhi")){
                e.click();
                break;
            }
        }*/

        //another method
        actions.moveToElement(fromCity).click().sendKeys("del").build().perform();
        Thread.sleep(3000);
        actions.moveToElement(fromCity).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();

    }

    @AfterTest
    public void closeBrowser() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

}
