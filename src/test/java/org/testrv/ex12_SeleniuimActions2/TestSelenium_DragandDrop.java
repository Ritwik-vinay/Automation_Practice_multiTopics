package org.testrv.ex12_SeleniuimActions2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testrv.base.TestSele_Start_End_Browser;

public class TestSelenium_DragandDrop extends TestSele_Start_End_Browser {
    @Test
    public void drag_and_drop(){
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement aBlock = driver.findElement(By.id("column-a"));
        WebElement bBlock= driver.findElement(By.id("column-b"));

        Actions action = new Actions(driver);
        checkvisibility(driver,By.id("column-a"));
        action.dragAndDrop(aBlock,bBlock).build().perform();

    }
}
