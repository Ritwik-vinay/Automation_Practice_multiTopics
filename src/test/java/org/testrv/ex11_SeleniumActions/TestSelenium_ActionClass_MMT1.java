package org.testrv.ex11_SeleniumActions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testrv.base.TestSele_Start_End_Browser;

import java.time.Duration;
import java.util.List;


public class TestSelenium_ActionClass_MMT1 extends TestSele_Start_End_Browser {
    @Test(priority = 0)
    public void verify_closeModalTab() {
        driver.get("https://www.makemytrip.com/");
        //wait until the driver gets visible
        checkvisibility(driver, By.xpath("//span[@data-cy='closeModal']"));
        WebElement closeModal = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
        closeModal.click();


    }

    @Test(priority = 1)
    public void Test_Flight_Search() throws InterruptedException {
        checkvisibility(driver, By.id("fromCity"));
        WebElement fromCity = driver.findElement(By.id("fromCity"));
        Actions act = new Actions(driver);
        act.moveToElement(fromCity).click(fromCity)
                .pause(Duration.ofSeconds(1))
                .sendKeys("Mum")
                .build()
                .perform();



        List<WebElement> cities = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li"));
        for (WebElement e : cities) {

            if (e.getText().contains("Mumbai")) {
                e.click();
            }
        }
        ////input[@placeholder='To']
        WebElement tocity= driver.findElement(By.id("toCity"));
        act.moveToElement(tocity).click(tocity)
                .pause(Duration.ofSeconds(1))
                .sendKeys("BLR")
                .build()
                .perform();
        List<WebElement> tocities= driver.findElements(By.xpath("//li[@class='react-autosuggest__suggestion']/div"));
        for (WebElement f:tocities){
            if (f.getText().contains("Bangalore")){
                f.click();
            }
        }



    }
}
