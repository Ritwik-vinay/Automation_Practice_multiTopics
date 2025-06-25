package org.testrv.ex13_Selenium_Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testrv.base.TestSele_Start_End_Browser;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestSelenium_ex3 extends TestSele_Start_End_Browser {
    @Test
    public void main() {
        //Verify the content of the Model
        driver.get("https://demoqa.com/modal-dialogs");
        checkvisibility(driver, By.id("showSmallModal"));
        WebElement smallModal = driver.findElement(By.id("showSmallModal"));
        smallModal.click();
        WebElement getBody = driver.findElement(By.xpath("//div[@class='modal-body']"));

        assertThat(getBody.getText().equalsIgnoreCase("//div[@class='modal-body']"));

        System.out.println(getBody.getText());
        checkvisibility(driver, By.id("closeSmallModal"));
        driver.findElement(By.id("closeSmallModal")).click();
        JVMwait(3000);
        checkvisibility(driver, By.id("showLargeModal"));
        WebElement largeModal = driver.findElement(By.id("showLargeModal"));
        largeModal.click();
        WebElement contentLargeModal = driver.findElement(By.xpath("//div[@class='modal-body']//p"));
        String largeModalBody = contentLargeModal.getText();
        System.out.println(largeModalBody);
        Assert.assertTrue(largeModalBody.contains("Lorem Ipsum is simply dummy text of the printing and typesetting industry"));
    }

}
