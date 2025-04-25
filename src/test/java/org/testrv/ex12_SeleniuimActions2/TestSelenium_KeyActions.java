package org.testrv.ex12_SeleniuimActions2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testrv.base.TestSele_Start_End_Browser;

public class TestSelenium_KeyActions extends TestSele_Start_End_Browser {
    @Test
    public void testKeyPress() {
        driver.get("https://the-internet.herokuapp.com/");
        Actions action = new Actions(driver);

        action.keyDown(Keys.PAGE_DOWN).keyUp(Keys.PAGE_DOWN).build().perform();
        checkvisibility(driver, (By.xpath("//a[@href=\"/key_presses\"]")));

        WebElement keypress = driver.findElement(By.xpath("//a[@href=\"/key_presses\"]"));
        keypress.click();
        WebElement target= driver.findElement(By.id("target"));
        target.click();
        action.keyDown(Keys.SHIFT).sendKeys("my name is Ritwik ").keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).build().perform();
        WebElement results= driver.findElement(By.id("result"));
        System.out.println(results.getText());
        JVMwait(3000);

    }
}
