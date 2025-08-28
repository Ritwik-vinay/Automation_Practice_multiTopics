package org.testrv.ex14_SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class refreshTheChrome {
    public  WebDriver driver = new ChromeDriver();
    @Test
    public void refresgTab1() throws InterruptedException {

        driver.get("https://google.com/");
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void refresgTab2() throws InterruptedException {

        driver.get("https://google.com/");
        driver.get(driver.getCurrentUrl());
        Thread.sleep(3000);
        driver.quit();
            }
    @Test
    public void refresgTab3() throws InterruptedException {

        driver.get("https://google.com/");
        driver.findElement(By.name("q")).sendKeys(Keys.F5);
        Thread.sleep(3000);
        driver.quit();

    }

}
