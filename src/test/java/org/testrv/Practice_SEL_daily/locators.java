package org.testrv.Practice_SEL_daily;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class locators {
    public static void main(String[] args) throws InterruptedException {
        //Write a reusable method to locate elements using:
        String product = "Premium Polo T-Shirts";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/login");
        driver.findElement(By.xpath("//input[@data-qa= 'login-email']")).sendKeys("rv123@test.com");
        driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys("@ritwik123");
        driver.findElement(By.cssSelector(".btn-default")).click();
        System.out.println(driver.getTitle());
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.findElement(By.id("search_product")).sendKeys("Tshirt");
        WebElement add_to_Cart = driver.findElement(By.cssSelector(".add-to-cart"));
        driver.findElement(By.id("submit_search")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> prod_List = driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"));
        for (WebElement e : prod_List) {
            String prod_names = e.getText();
            if (prod_names.equalsIgnoreCase(product)) {
                WebElement scrollToProduct = driver.findElement(By.xpath("//div[@class='product-overlay']"));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                scrollToProduct.findElements(By.xpath("//a[@class='btn btn-default add-to-cart'] "));



            }
        }
        driver.quit();
    }
}
