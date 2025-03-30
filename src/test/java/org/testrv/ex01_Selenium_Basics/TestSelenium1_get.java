package org.testrv.ex01_Selenium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestSelenium1_get {
    //https://app.vwo.com
    @Test(groups = "qa")
    @Description("Verify the Navigation to the WebPage and getSession iD and getTitle")
    public void navigatetoURL() {
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");
        System.out.println(driver.getSessionId());
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
