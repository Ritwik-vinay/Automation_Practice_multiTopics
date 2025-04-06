package org.testrv.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class TestSele_Start_End_Browser {
    public static EdgeOptions options = new EdgeOptions();

    @BeforeClass
    public static void browserOptions() {
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--start-maximized");


        options.addArguments("--disable-dev-shm-usage");
    }

    public static WebDriver driver = new EdgeDriver(options);

    @BeforeTest
    public static void startBrowser() {
        //driver.manage().window().maximize();
    }

    @AfterTest
    public static void quitBrowser() {
        driver.quit();
    }
}
