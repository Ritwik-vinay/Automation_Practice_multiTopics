package org.testrv.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testrv.ex07_Selenium_waithelper.TestSelenium_Waits;

public class TestSele_Start_End_Browser extends TestSelenium_Waits {
//    public static EdgeOptions options = new EdgeOptions();

//    @BeforeClass
//    public static void browserOptions() {
//        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//        options.setExperimentalOption("useAutomationExtension", false);
//
//        options.addArguments("--disable-blink-features=AutomationControlled");
//        options.addArguments("--start-maximized");
//
//
//        options.addArguments("--disable-dev-shm-usage");
//    }

    public static WebDriver driver = new ChromeDriver();

    @BeforeTest
    public static void startBrowser() {
        driver.manage().window().maximize();
    }

    @AfterTest
    public static void quitBrowser() {
        waitImplicitWait(driver,3);
        driver.quit();
    }
}
