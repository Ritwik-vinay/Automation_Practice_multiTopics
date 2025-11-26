package org.testrv.ex14_SeleniumPractice;

import io.qameta.allure.Description;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testrv.base.TestSele_Start_End_Browser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class brokenLinks extends TestSele_Start_End_Browser {
    @Test
    @Description("Find the Broken Link")
    public void brokenLink() throws IOException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> links =driver.findElements(By.tagName("a"));
        System.out.println("Total links: " + links.size());
        CloseableHttpClient client = HttpClients.createDefault();
        for (WebElement link : links ){
            String url = link.getAttribute("href");
            if (url == null || url.isEmpty()) {
                System.out.println("Skipping empty link: " + link.getText());
                continue;
            }
            HttpGet request = new HttpGet(url);

            try (CloseableHttpResponse response = client.execute(request)) {
                int status = response.getCode();


                if (status >= 400) {
                System.out.println("❌ Broken Link: " + url + " — Status Code: " + status);
            } else {
                System.out.println("✔️ Valid Link: " + url + " — Status Code: " + status);
                }
            }
                catch (Exception e) {
                    System.out.println("⚠ Error checking link: " + url + " | Exception: " + e.getMessage());
                }
            }

            client.close();
        }
    }

