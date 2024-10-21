package org.example.ex_Selenium.ex_19102024;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebDriver;

public class Selenium19 {

    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");

        driver.close();
        // Close the Current Browser Window
        // Session ID != NULL
        // Not the full browser

        driver.quit();
        // Close all the /sessions/windows and stop the browser
        // Session = null, Error - Session ID is null

    }

}
