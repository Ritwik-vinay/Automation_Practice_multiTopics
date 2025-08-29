package org.testrv.ex14_SeleniumPractice;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class seleniumWebDriver {
    @Test
    @Description("Using the UNIT WEBDRIVER")
    public void unitWD(){
        //New Driver in Headless mode

        WebDriver driver = new HtmlUnitDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        String text = driver.getTitle();
        System.out.println(text);
    }
}
