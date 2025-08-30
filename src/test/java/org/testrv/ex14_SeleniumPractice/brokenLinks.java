package org.testrv.ex14_SeleniumPractice;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testrv.base.TestSele_Start_End_Browser;

public class brokenLinks extends TestSele_Start_End_Browser {
    @Test
    @Description("Find the Broken Link")
    public void brokenLink(){
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        WebElement tags =driver.findElement(By.tagName("a"));
        String tagName = tags.getText();
        System.out.println(tagName);
    }
}
