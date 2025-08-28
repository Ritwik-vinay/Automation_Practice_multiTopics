package org.testrv.ex14_SeleniumPractice;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class maximizeTheBrowser {
    @Test
    public void maximize() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com/");
        Thread.sleep(3000);

        driver.quit();
    }
    @Test
    public void resize() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Dimension size = new Dimension(800,400);
        driver.manage().window().setSize(size);
        driver.get("https://google.com/");

        Thread.sleep(5000);
        driver.quit();
    }
}
