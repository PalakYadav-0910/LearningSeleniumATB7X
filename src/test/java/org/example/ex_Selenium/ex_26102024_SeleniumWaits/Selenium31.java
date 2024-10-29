package org.example.ex_Selenium.ex_26102024_SeleniumWaits;

import io.qameta.allure.Description;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Selenium31 {

    @Description("Verify Ebay Print the prices (iMac)")
    @Test
    public void test_verify_print_imac_price() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--start-maximized");

        EdgeDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

    }

}
