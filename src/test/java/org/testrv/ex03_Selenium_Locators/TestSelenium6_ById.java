package org.testrv.ex03_Selenium_Locators;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;
import org.testrv.ex07_Selenium_waithelper.TestSelenium_Waits;

import static org.assertj.core.api.Assertions.assertThat;

public class TestSelenium6_ById extends TestSelenium_Waits {
    @Test
    @Description("Validate the Error Message")
    public void verify_errormessgae(){
        EdgeOptions options = new EdgeOptions();

        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com/");
        driver.manage().window().maximize();
        WebElement username =driver.findElement(By.id("login-username"));
        username.sendKeys("abs@gmail.com");
        WebElement password=driver.findElement(By.id("login-password"));
        password.sendKeys("pass");
        WebElement submitBtn = driver.findElement(By.id("js-login-btn"));
        submitBtn.click();
        WebElement errorMessage= driver.findElement(By.id("js-notification-box-msg"));
        checkVisibilityOfAndTextToBePresentInElement(driver, errorMessage,"Your email, password, IP address or location did not match");

        String error= errorMessage.getText();
        assertThat(error.equalsIgnoreCase("Your email, password, IP address or location did not match"));
        driver.quit();

    }

}
