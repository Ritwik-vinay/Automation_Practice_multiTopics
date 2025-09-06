package org.testrv.ex14_SeleniumPractice;

import io.qameta.allure.Description;
import org.assertj.core.api.ThrowableAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testrv.base.TestSele_Start_End_Browser;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class handleAlerts extends TestSele_Start_End_Browser {
    @Test
    @Description("Handling to capture the Alert msg and confirm msg")
    public void getAndCaptureAlertmsg() throws InterruptedException {
        //1.go to the url //2.Navigate to alert button
        //3. Click on the alert button //4. Capture string
        //5. Use assert to validate //6. Click on OK
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement name = driver.findElement(By.id("name"));
        WebElement alert_btn= driver.findElement(By.id("alertbtn"));
        WebElement conffirmBtn= driver.findElement(By.id("confirmbtn"));
        name.sendKeys("RITWIK VINAY");

        alert_btn.click();
        String alert_msg= driver.switchTo().alert().getText();
        System.out.println(alert_msg);
        assertThat(alert_msg.equalsIgnoreCase("Hello RITWIK VINAY, share this practice page and share your knowledge"));
        driver.switchTo().alert().accept();
        checkvisibility(driver,By.id("confirmbtn") );
        name.sendKeys("RITWIK VINAY");
        conffirmBtn.click();
        String cnfrm_msg= driver.switchTo().alert().getText();
        System.out.println(cnfrm_msg);
        Thread.sleep(3000);
        assertThat(alert_msg.equalsIgnoreCase("Hello RITWIK VINAY, Are you sure you want to confirm"));
        driver.switchTo().alert().dismiss();


    }

}
