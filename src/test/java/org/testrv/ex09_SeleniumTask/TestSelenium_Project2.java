package org.testrv.ex09_SeleniumTask;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testrv.ex07_Selenium_waithelper.TestSelenium_Waits;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestSelenium_Project2 extends TestSelenium_Waits {
    WebDriver driver = new EdgeDriver();

    @BeforeTest
    @Description("Test Start the Browser")
    public void StarttheBrowser() {
        driver.navigate().to("https://demo.applitools.com/");

    }

    @Test
    public void verifytheFrames() {
        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Password@123");
        WebElement submit = driver.findElement(By.cssSelector(".btn.btn-primary"));
        submit.click();
        assertThat(driver.getCurrentUrl().equalsIgnoreCase("https://demo.applitools.com/app.html"));
        List<WebElement> amounts = driver.findElements(By.xpath("//td[@class='text-right bolder nowrap']"));
        Float totalsum = 0f;

        for (WebElement amt : amounts) {
            String amount = amt.getText().trim();
            boolean isNegative = amount.startsWith("-");
            String cleanAmount = amount.replaceAll("[^0-9.-]", "");
            Float numericAmount = Float.parseFloat(cleanAmount);

            totalsum += numericAmount;
            System.out.println("Amount " + numericAmount);


        }
        System.out.println("Total Sum " + totalsum);
        assertThat(totalsum.equals(1996.22));

    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
