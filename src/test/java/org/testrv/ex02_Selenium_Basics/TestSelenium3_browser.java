package org.testrv.ex02_Selenium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestSelenium3_browser {
    @Test
    @Description("Verify WebDriver, browser and SearchContext for the initalization")
    public void verifyBrowsers(){
        WebDriver driver = new EdgeDriver();

        System.out.println(driver.getClass());
        SearchContext  scdriver = new ChromeDriver();
        System.out.println(scdriver.getClass());
        FirefoxDriver fdriver = new FirefoxDriver();
        System.out.println(fdriver.getClass());

    }
}
