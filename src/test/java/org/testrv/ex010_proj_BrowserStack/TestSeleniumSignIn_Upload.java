package org.testrv.ex010_proj_BrowserStack;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testrv.base.TestSele_Start_End_Browser;
import org.testrv.ex07_Selenium_waithelper.TestSelenium_Waits;

import java.time.Duration;

public class TestSeleniumSignIn_Upload extends TestSele_Start_End_Browser {
    @Test
    @Description("Login with the username and password, then Upload the 'APK File'")
    public void Test_UploadFlowEndtoEnd(){

       driver.get("https://app-automate.browserstack.com/dashboard/v2/introduction");
//        WebElement businessEmail=driver.findElement(By.xpath("//input[@placeholder='Business Email']"));
//        businessEmail.sendKeys("ritwikvinay38@gmail.com");
//        //Password
//        WebElement password=driver.findElement(By.xpath("//input[@placeholder='Password']"));
//        password.sendKeys("@BrowserStack123");
//        WebElement signupbtn= driver.findElement(By.id("user_submit"));
//        signupbtn.click();
        WebElement googlebtn= driver.findElement(By.xpath("//a[@class='btn btn-secondary-gray col-center oauth-btn google-logo-btn']"));
        googlebtn.click();
       WebElement emailid=driver.findElement(By.cssSelector("input[id='identifierId']"));
       


        TestSelenium_Waits.JVMwait(5000);
      //  TestSelenium_Waits.checkvisibility(driver,By.xpath("//span[@class='aa-app-uploader__upload-text align-self-center']"),15000 );
        //WebElement upload = driver.findElement(By.xpath("//span[@class='aa-app-uploader__upload-text align-self-center']"));

       // upload.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://app-automate.browserstack.com/dashboard/v2/introduction");
        System.out.println(driver.getCurrentUrl());

    }
}
