package org.example.ex_Selenium.ex_12102024;

import org.openqa.selenium.edge.EdgeDriver;

public class Selenium07 {
    public static void main(String[] args) {

        EdgeDriver driver = new EdgeDriver();
        driver.get("https://sdet.live");
        driver.quit();

    }

}
