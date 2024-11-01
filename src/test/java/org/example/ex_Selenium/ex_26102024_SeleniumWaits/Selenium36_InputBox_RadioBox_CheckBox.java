package org.example.ex_Selenium.ex_26102024_SeleniumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium36_InputBox_RadioBox_CheckBox {

    public static void main(String[] args) {

        EdgeDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/practice.html");

        driver.findElement(By.name("firstname")).sendKeys("palak");

        //Radio Box
        driver.findElement(By.id("sex-1")).click();

        //Check Box
        driver.findElement(By.id("profession-1")).click();

    }
}
