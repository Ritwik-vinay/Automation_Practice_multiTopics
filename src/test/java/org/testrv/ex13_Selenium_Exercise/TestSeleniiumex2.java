package org.testrv.ex13_Selenium_Exercise;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testrv.base.TestSele_Start_End_Browser;

import java.util.List;

public class TestSeleniiumex2 extends TestSele_Start_End_Browser {
    //Navigate to the Web Tables - Pgae - https://demoqa.com/webtables
    //Click on the 3rd edit button
    //Click on the Add and Add a new Row and  verify in table.
    //Verify the details.
    //Try to create a generic locator so that it won't break if we add new rows.
    @Test
    @Description("Verify the WebTable")
    public void verify_webTables() {
        driver.get("https://demoqa.com/webtables");
        Actions action = new Actions(driver);

        WebElement clickele = driver.findElement(By.cssSelector("span[id='edit-record-3'] svg "));
        checkvisibility(driver, By.cssSelector("span[id='edit-record-3'] svg "));
        action.sendKeys(Keys.PAGE_DOWN).perform();
        clickele.click();

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        checkvisibility(driver, By.id("addNewRecordButton"));
        WebElement clicktoAdd = driver.findElement(By.id("addNewRecordButton"));
        clicktoAdd.click();
        JVMwait(3000);
        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        WebElement email = driver.findElement(By.id("userEmail"));
        WebElement age = driver.findElement(By.id("age"));
        WebElement salary = driver.findElement(By.id("salary"));
        WebElement department = driver.findElement(By.id("department"));
        firstName.sendKeys("Ritwik");
        lastName.sendKeys("vinay");
        email.sendKeys("abcTest@yopmail.com");
        age.sendKeys("30");
        salary.sendKeys("238");
        department.sendKeys("Computer Science");
        driver.findElement(By.id("submit")).click();
        List<WebElement> newEntry = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        for (WebElement entry : newEntry) {
            checkvisibility(driver, By.xpath("//div[@class='rt-tr-group']"));
            String entryvalue = entry.getText();
            if (entryvalue.contains("Ritwik")) {
                System.out.println(entryvalue);
            }
        }

    }

}
