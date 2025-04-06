package org.testrv.ex010_proj_BrowserStack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testrv.base.TestSele_Start_End_Browser;
import org.testrv.ex07_Selenium_waithelper.TestSelenium_Waits;

import static org.assertj.core.api.Assertions.assertThat;

public class TestSelenium_Signup_Browserstack extends TestSele_Start_End_Browser {

    @Test
    public void signupBrowser(){
        driver.get("https://www.browserstack.com/users/sign_up");
        WebElement firstName= driver.findElement(By.xpath("//input[@placeholder='Full name']"));
        firstName.sendKeys("Ritwik Vinay");
        WebElement businessEmail=driver.findElement(By.xpath("//input[@placeholder='Business Email']"));
        businessEmail.sendKeys("ritwikvinay38@gmail.com");
        //Password
        WebElement password=driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("@BrowserStack123");
        TestSelenium_Waits.JVMwait(3000);

        WebElement termsandCond =driver.findElement(By.xpath("//input[@class='bs-checkbox signup-checkbox']"));
        termsandCond.click();
        TestSelenium_Waits.JVMwait(3000);
        WebElement signupbtn= driver.findElement(By.id("user_submit"));
        signupbtn.click();
        TestSelenium_Waits.JVMwait(3000);
        System.out.println(driver.getCurrentUrl());
        assertThat(driver.getCurrentUrl().equalsIgnoreCase("https://accounts.browserstack.com/confirmation"));

    }
}
