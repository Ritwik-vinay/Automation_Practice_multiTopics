package org.testrv.ex14_SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class clickHyperLink {
    @Test
    public void Hyperlink(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        WebDriver driver= new ChromeDriver(options);
        driver.get("https://google.com/");
        WebElement name= driver.findElement(By.name("q"));
        name.sendKeys("The Testing Academy");
        name.sendKeys(Keys.ENTER);
      //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


//        WebElement linkText= driver.findElement(By.linkText("Software Testing & Acceptance - All Courses Online & Free"));
//     //   wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("The Testing Academy")));
//        linkText.click();

        driver.close();

    }
}
