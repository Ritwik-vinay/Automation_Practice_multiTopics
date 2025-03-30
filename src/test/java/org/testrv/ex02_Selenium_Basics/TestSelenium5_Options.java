package org.testrv.ex02_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class TestSelenium5_Options {
    @Test
    public void ValidateTheOptions(){

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--headless");
        WebDriver driver = new EdgeDriver();
        driver.navigate().to("https://www.google.com/");
        System.out.println(driver.getCurrentUrl());

        driver.quit();

    }
}
