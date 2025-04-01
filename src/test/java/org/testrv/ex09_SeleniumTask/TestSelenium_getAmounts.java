package org.testrv.ex09_SeleniumTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testrv.base.TestSele_Start_End_Browser;

import java.util.List;

public class TestSelenium_getAmounts extends TestSele_Start_End_Browser {

    @Test
    public void getAmount() {

        driver.get("https://demoqa.com/webtables");
        List<WebElement> salaries = driver.findElements(By.xpath("//div[@class='rt-tr-group']/div/div[5]"));
        int sum = 0;

        for (WebElement salary : salaries) {

            String value = salary.getText().trim();

            // Ensure value is not empty and is a valid number
            if (!value.isEmpty() && value.matches("\\d+")) {
                int priceValue = Integer.parseInt(value);
                sum += priceValue;
                System.out.println("Amount: " + priceValue);
            }
        }


        System.out.println("Total amount: " + sum);


    }
}