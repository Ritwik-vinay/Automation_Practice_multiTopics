package org.testrv.ex14_SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testrv.base.TestSele_Start_End_Browser;

public class Automate_Page_Component extends TestSele_Start_End_Browser {
    @Test
    public void drag_DROP_Test() throws InterruptedException {
        driver.get("https://testautomationpractice.blogspot.com/");
        Actions actions = new Actions(driver);
        WebElement draggable= driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        actions.moveToElement(draggable).build().perform();
        actions.dragAndDrop(draggable,droppable).build().perform();
        String text= driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();
        System.out.println(text);
    }

    @Test
    public void date_Pickr(){
        driver.get("");
        driver.findElement(By.id("datepicker")).click();
        checkvisibility(driver, By.cssSelector(".ui-datepicker-calendar"));
        


    }
}
