package org.testrv.Practice_SEL_daily;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testrv.base.TestSele_Start_End_Browser;

public class ebay_example extends TestSele_Start_End_Browser {
    @Test
    @Description("The test is just to confirm the ebay methods ")
    public void test_Ebay_webSite_start() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();

        driver.get("https://ebay.com/in/");
       // Thread.sleep(5000);
        try{
            checkvisibility(driver, By.xpath("//button[text()='Decline all']"));
            driver.findElement(By.xpath("//button[text()='Decline all']")).click();
            System.out.println("cookies rejected");
        }
        catch (Exception e){
            System.out.println("No cookies poped_up!!");
        }
    }
}
