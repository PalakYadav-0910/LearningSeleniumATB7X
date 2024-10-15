package org.example.ex_Selenium;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium02 {
    public static void main(String[] args) {

        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://app.vwo.com");

    }
}
