package org.testrv.ex04_Selenium_Practice1301;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class domHandleDynamicButton {
    WebDriver driver = new ChromeDriver();

    @Test
    @Description("DOM Handle Dynamic Button ")
    void domExampleSetup() {
        driver.navigate().to("https://the-internet.herokuapp.com/challenging_dom#edit");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<WebElement> buttons =
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//a[contains(@class,'button')]")
                ));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (WebElement button : buttons) {

            String buttonName = button.getText();

            button.click();

            String value = (String) js.executeScript(
                    "return document.body.innerHTML.match(/Answer: (\\d+)/)[1];"
            );

            System.out.println(buttonName + " → Answer: " + value);
        }
    }
}

