package org.testrv.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestSele_Start_End_Browser {
    public static WebDriver driver = new EdgeDriver();
    @BeforeTest
    public static void startBrowser(){

       driver.manage().window().maximize();
    }
    @AfterTest
    public static void quitBrowser(){
        driver.quit();
    }
}
