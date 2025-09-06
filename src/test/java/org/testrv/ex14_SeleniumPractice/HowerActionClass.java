package org.testrv.ex14_SeleniumPractice;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testrv.base.TestSele_Start_End_Browser;

public class HowerActionClass extends TestSele_Start_End_Browser {
    @Test
    @Description("Hower to the button and perform actions")
    public void hower_action() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement howerBtn = driver.findElement(By.id("mousehover"));
        Actions actions = new Actions(driver);
        actions.moveToElement(howerBtn).build().perform();
        checkvisibility(driver, By.xpath("(//div[@class='mouse-hover-content']/a)"));
        WebElement reloadPage = driver.findElement(By.xpath("(//div[@class='mouse-hover-content']/a) [2]"));
        actions.click(reloadPage).build().perform();
        Thread.sleep(5000);
    }
}
