package org.testrv.ex09_SeleniumTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testrv.base.TestSele_Start_End_Browser;
import org.testrv.ex07_Selenium_waithelper.TestSelenium_Waits;

import java.time.Duration;

public class TestingSelenium_ch3 extends TestSele_Start_End_Browser {
    @Test
    public void test_3rd_editButton (){
        driver.get("https://demoqa.com/webtables");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
     //   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    //    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='edit-record-3']//*[name()='svg']//*[name()='path']")));
        WebElement editbutton= driver.findElement(By.xpath("//span[@id='edit-record-3']//*[name()='svg']"));
        editbutton.click();

     //   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Salary']")));

        WebElement salary= driver.findElement(By.xpath("//input[@placeholder='Salary']"));
        salary.sendKeys("5000");
        WebElement submit= driver.findElement(By.xpath("//button[@id='submit']"));
        submit.click();
        WebElement rowvalue= driver.findElement(By.xpath("(//div[@role='row'])[4]"));
        System.out.println(rowvalue.getText());
    }

}
