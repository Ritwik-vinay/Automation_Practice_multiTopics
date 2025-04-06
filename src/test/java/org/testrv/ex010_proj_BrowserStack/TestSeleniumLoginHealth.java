package org.testrv.ex010_proj_BrowserStack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;
import org.testrv.base.TestSele_Start_End_Browser;

import java.util.HashMap;

public class TestSeleniumLoginHealth extends TestSele_Start_End_Browser {
    @Test
    public void loginUrl() {
        String USERNAME = "ritwikvinay_nY0yie";
        String AUTOMATE_KEY = "rxDxxqBn7KJ9TgAZvdCs";
        String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
        driver.get(URL);
        WebElement automate= driver.findElement(By.xpath("automate_cross_product_explore"));
        automate.click();
        System.out.println(driver.getCurrentUrl());
    }
}