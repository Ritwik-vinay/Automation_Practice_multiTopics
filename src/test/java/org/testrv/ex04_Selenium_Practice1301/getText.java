package org.testrv.ex04_Selenium_Practice1301;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class getText {
    WebDriver driver = new ChromeDriver();
    @Test
    @Description("Getting the text from the basic webPage")
    void getTextValues() {

        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("A/B Testing")).click();
        String content = driver.findElement(By.xpath("//div[@id= 'content']")).getText();
        System.out.println(content);
        String actual= "A/B Test Variation 1\n" +
                "Also known as split testing. This is a way in which businesses are able to simultaneously test and learn different versions of a page to see which text and/or functionality works best towards a desired outcome (e.g. a user action such as a click-through).";
        Assert.assertEquals(actual, content);

    }

    @AfterTest
    void closeBrowse() {
        driver.quit();

    }

}
