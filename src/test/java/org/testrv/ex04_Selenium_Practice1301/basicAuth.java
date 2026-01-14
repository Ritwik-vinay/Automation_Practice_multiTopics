package org.testrv.ex04_Selenium_Practice1301;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class basicAuth {
    WebDriver driver = new ChromeDriver();
    @Test
    @Description("Auth on the Chrome Options")
    void oauthValidation(){
        driver.navigate().to("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Basic Auth")).click();
        driver.navigate().to(
                "https://admin:admin@the-internet.herokuapp.com/basic_auth"
        );
        String exampleText= driver.findElement(By.xpath("//div[@class='example']")).getText();
        System.out.println(exampleText);
    }
    @AfterTest
    void quitBrowser(){
        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }
}
