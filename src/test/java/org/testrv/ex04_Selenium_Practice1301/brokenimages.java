package org.testrv.ex04_Selenium_Practice1301;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class brokenimages {
    WebDriver driver = new ChromeDriver();

    @Test
    @Description("Broken Images values")
    void brokenImagesValues() throws Exception {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Broken Images")).click();
        String text = driver.findElement(By.tagName("h3")).getText();
        List<WebElement> images = driver.findElements(By.xpath("//div/img"));
        System.out.println("Total images: " + images.size());

        for (WebElement img : images) {
            String imageUrl = img.getAttribute("src");

            if (imageUrl == null || imageUrl.isEmpty()) {
                System.out.println("image src is empty");
                continue;
            }
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                System.out.println("Broken Image: " + imageUrl +
                        " | Response Code: " + responseCode);
            }

        }

        driver.quit();


    }
}
