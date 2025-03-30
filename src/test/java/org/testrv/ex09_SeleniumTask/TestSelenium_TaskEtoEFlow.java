package org.testrv.ex09_SeleniumTask;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testrv.ex07_Selenium_waithelper.TestSelenium_Waits;

public class TestSelenium_TaskEtoEFlow extends TestSelenium_Waits {
    WebDriver driver = new EdgeDriver();

    @BeforeTest
    public void starttheBrowserwithURL() {
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
    }

    @Test
    @Description("Verify the End to End Flow for the Booking Confirmation and get back to Home page")
    public void verifyEtoEFlow() {
        WebElement makeAppointment = driver.findElement(By.cssSelector("a[class='btn btn-dark btn-lg']"));
        makeAppointment.click();
        WebElement username = driver.findElement(By.name("username"));
        JVMwait(3000);
        username.sendKeys("John Doe");
        WebElement password = driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");
        WebElement loginnbtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginnbtn.click();
        WebElement select_element = driver.findElement(By.cssSelector("select[id='combo_facility']"));
        Select select = new Select(select_element);
        select.selectByVisibleText("Hongkong CURA Healthcare Center");
        driver.findElement(By.id("chk_hospotal_readmission")).click();
        WebElement visitDate=driver.findElement(By.cssSelector("input[placeholder='dd/mm/yyyy']"));
        visitDate.sendKeys("01/04/2025");
        WebElement commentBox= driver.findElement(By.name("comment"));
        commentBox.sendKeys("Testintg the Appointment Log");
        WebElement btn_BookAppointment= driver.findElement(By.id("btn-book-appointment"));
        btn_BookAppointment.click();
        WebElement actualText=driver.findElement(By.xpath("//div[@class='col-xs-12 text-center'] //h2"));
        checkVisibilityOfAndTextToBePresentInElement(driver,actualText,"Appointment Confirmation");
        System.out.println(actualText.getText());
        WebElement HomePage =driver.findElement(By.xpath("//a[@class='btn btn-default']"));
        HomePage.click();
        System.out.println(driver.getCurrentUrl());


    }

    @AfterTest
    public void quitbrowser() {
        driver.quit();
    }
}
