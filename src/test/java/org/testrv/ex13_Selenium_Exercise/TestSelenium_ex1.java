package org.testrv.ex13_Selenium_Exercise;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testrv.base.TestSele_Start_End_Browser;

public class TestSelenium_ex1 extends TestSele_Start_End_Browser {
    @Test
    @Description("Testing the Feature to validate the webpage and price")
    public void verify_webpage_Title(){
        driver.get("https://demo.applitools.com/");
        WebElement username=driver.findElement(By.id("username"));
        username.sendKeys("Admin");
        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys("Password@123");
        driver.findElement(By.id("log-in")).click();
        String url=driver.getCurrentUrl();
        Assert.assertTrue(url.contains("app.html"),"URL does not contain 'app.html'");

    }
}
