package org.example.ex_Selenium.Task_19Oct;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AwesomeQA {

    @Description("Positive TC : Verify that account is registered successfully.")
    @Test
    public void registerTC(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/ui/index.php?route=account/register");
        driver.manage().window().maximize();

        Assert.assertEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/register");
        Assert.assertEquals(driver.getTitle(), "Register Account");

        Faker faker = new Faker();

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys(faker.name().firstName());

        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys(faker.name().lastName());

        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys(faker.internet().emailAddress());

        WebElement phone = driver.findElement(By.id("input-telephone"));
        phone.sendKeys(faker.phoneNumber().cellPhone());

        WebElement password = driver.findElement(By.id("input-password"));
        WebElement confirm_pswd = driver.findElement(By.id("input-confirm"));

        String pswd = faker.internet().password();
        password.sendKeys(pswd);
        confirm_pswd.sendKeys(pswd);

        List<WebElement> radio = driver.findElements(By.name("newsletter"));
        radio.get(1).click();

        WebElement checkbox = driver.findElement(By.name("agree"));
        checkbox.click();

        WebElement continueBtn = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueBtn.click();

        Assert.assertEquals(driver.getPageSource().contains("Your Account Has Been Created!"), true);

        driver.quit();

    }
}
