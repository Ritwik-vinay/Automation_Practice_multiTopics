package org.testrv.ex02_Selenium_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Set;

public class switchBrowser {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        String parentWindow = driver.getWindowHandle();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open();");

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
       driver.switchTo().window(tabs.get(1));


       driver.get("https://google.com");
        //driver.quit();
    }

}
