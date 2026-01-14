package org.testrv.ex04_Selenium_Practice1301;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class addRemoveElement {
    WebDriver driver = new ChromeDriver();
    @Test
    void addElement (){
        driver.get("https://the-internet.herokuapp.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.linkText("Add/Remove Elements")).click();
        WebElement element_Button = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        wait.until(ExpectedConditions.elementToBeClickable(element_Button));
        element_Button.click();
        WebElement ele = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        wait.until(ExpectedConditions.elementToBeClickable(ele));
        ele.click();



    }
    @AfterTest
    void quitBrowser(){
        driver.quit();
    }
}
