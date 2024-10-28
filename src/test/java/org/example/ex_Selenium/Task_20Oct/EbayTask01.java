package org.example.ex_Selenium.Task_20Oct;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.List;

public class EbayTask01 {

    @Description("Search macmini and find minimum price macmini")
    @Test
    public void findMinPriceMacMini() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067");

        Thread.sleep(3000);

        WebElement searchBar = driver.findElement(By.xpath("//input[@placeholder = 'Search for anything']"));
        searchBar.sendKeys("macmini");

        WebElement searchBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        searchBtn.click();

        Thread.sleep(3000);

        List<WebElement> titles = driver.findElements(By.cssSelector(".s-item__title"));
        List<WebElement> prices = driver.findElements(By.cssSelector(".s-item__price"));

        int size = Math.min(titles.size(),prices.size());

        for(int i=2; i<size; i++){
            System.out.println("Title : " + titles.get(i).getText() + " || " + "Price : " + prices.get(i).getText());
        }

        Double minPrice = Double.MAX_VALUE;
        for(int i=2; i< prices.size(); i++){
            String price = prices.get(i).getText();

            if(price.contains(" to ")){
                price = price.substring(0, price.indexOf(" to ")).trim();
            }

            if(price.startsWith("$")){
                price = price.substring(1);
            }

            Double doublePrice = Double.parseDouble(price);
            System.out.println("\n" + doublePrice);
            if(doublePrice<minPrice){
                minPrice = doublePrice;
            }
        }

        System.out.println("\n" + "Minimum Price is : " + minPrice);

        driver.quit();

    }
}
