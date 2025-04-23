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
        checkvisibility(driver, By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li"));


        List<WebElement> cities = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li"));
        for (WebElement e : cities) {
            //
            JVMwait(2000);
            if (e.getText().contains("Mumbai")) {

                e.click();
                break;
            }
        }
        JVMwait(3000);
        ////input[@placeholder='To']
        WebElement tocity = driver.findElement(By.id("toCity"));
        act.moveToElement(tocity).click(tocity)
                .pause(Duration.ofSeconds(1))
                .sendKeys("BLR")
                .build()
                .perform();
        checkvisibility(driver, By.xpath("//li[@class='react-autosuggest__suggestion']/div"));
        List<WebElement> tocities = driver.findElements(By.xpath("//li[@class='react-autosuggest__suggestion']/div"));
        for (WebElement f : tocities) {

            if (f.getText().contains("Bengaluru")) {
                f.click();
                break;
            }
        }
        ////div[@class='DayPicker-Day']
        checkvisibility(driver, By.xpath("//div[contains(@class, 'DayPicker-Caption')]/div"));
        List<WebElement> months = driver.findElements(By.xpath("//div[contains(@class, 'DayPicker-Caption')]/div"));
        for (WebElement month : months) {
            WebElement caption = month.findElement(By.xpath("//div[@class='DayPicker-Caption']/div"));
            String monthText = caption.getText();
            if (monthText.contains("May")) {
                List<WebElement> days = month.findElements(By.xpath("//div[@class='dateInnerCell']/p"));
                for (WebElement day : days) {
                    String dayText = day.getText();
                    if (dayText.contains("15")) {
                        day.click();
                        break;

                    }
                }

            } else {
                WebElement nextmonth = driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
                nextmonth.click();
            }
        }


        checkvisibility(driver, By.xpath("//p[@data-cy='submit']/a"));
        WebElement submitbtn = driver.findElement(By.xpath("//p[@data-cy='submit']/a"));
        submitbtn.click();
        System.out.println(driver.getCurrentUrl());

        JVMwait(3000);


    }
}
