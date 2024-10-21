package org.example.ex_Selenium.ex_19102024;

import org.testng.annotations.Test;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium15 {

    @Test
    public void vwoLogin() {

        EdgeDriver driver = new EdgeDriver();
        driver.get("https://sdet.live");
        driver.quit();

    }

}
