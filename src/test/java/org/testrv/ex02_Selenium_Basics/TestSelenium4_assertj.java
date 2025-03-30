package org.testrv.ex02_Selenium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestSelenium4_assertj {
    @Test
    @Description("Verifying the open URL Assertj")
    public void validateWithAssertJ(){
        WebDriver driver= new EdgeDriver();
        driver.get("https://google.com");

        assertThat(driver.getCurrentUrl()).isNotBlank().isNotNull().isEqualTo("https://www.google.com/");
        driver.quit();

    }
}