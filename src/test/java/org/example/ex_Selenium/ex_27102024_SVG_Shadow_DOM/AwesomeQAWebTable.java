package org.example.ex_Selenium.ex_27102024_SVG_Shadow_DOM;

import org.openqa.selenium.By;

import org.openqa.selenium.edge.EdgeDriver;

public class AwesomeQAWebTable {

    public static void main(String[] args) {

        EdgeDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/webtable.html");
        driver.manage().window().maximize();

        int row = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
        int col = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td")).size();

        for(int i = 2; i<=row; i++){
            for(int j =1 ; j<=col; j++){

                String value = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + i + "]/td[" + j + "]")).getText();
                System.out.print(value + "\t" + "|");
            }

            System.out.println();
        }

    }
}
