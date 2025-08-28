package org.testrv.ex14_SeleniumPractice;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testrv.base.TestSele_Start_End_Browser;

import java.util.Arrays;
import java.util.List;

public class getText_WebElement extends TestSele_Start_End_Browser {
    @Test
    @Description("Get the Text of the webElement")
    public void webElementGetText() throws InterruptedException {
        //GetText
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        Thread.sleep(5000);
        checkvisibility(driver, By.cssSelector("div[class='brand greenLogo']"));
        WebElement logo = driver.findElement(By.cssSelector("div[class='brand greenLogo']"));
        String logoName = logo.getText();
        Assert.assertEquals("GREENKART", logoName);

    }

    @Test
public void getProductNames() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        Thread.sleep(5000);
        String[] itemNeeded = {"Cucumber", "Onion", "Apple"};
        List<String> itemNeededList = Arrays.asList(itemNeeded);
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='product']"));
        int itemsAdded = 0;
        for (WebElement product : products) {
            
            String productNames = product.findElement(By.xpath(".//h4[@class='product-name']")).getText();
            String[] name = productNames.split("-");
            String trimName = name[0].trim();

            if (itemNeededList.contains(trimName)) {
                  WebElement addToCartBtn = product.findElement(By.xpath(".//div[@class='product-action']/button"));
                addToCartBtn.click();
               }
            }
           Thread.sleep(7000);
            driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
    }


}
