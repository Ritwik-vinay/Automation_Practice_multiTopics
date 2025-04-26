package org.testrv.ex12_SeleniuimActions2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testrv.base.TestSele_Start_End_Browser;

import java.util.List;
import java.util.Set;

public class TestSelenium_HoverActions extends TestSele_Start_End_Browser {
    @Test
    public void testActions_hover(){
        //1. Navigate to the url - `driver.get("https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1");`
        //2. Move to the element of variation 1 -> Hover it -> click on it
        //3. Switch to the next window -
        //4. wait for 15 seconds to load the page.
        //5. Switch to the iframe -> Clickmap button
        //6. Click on the clickmap button.
        driver.get("https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=");
        String parentWindow= driver.getWindowHandle();
        System.out.println("Parent window"+ parentWindow);
        List<WebElement> ViewHeatmap= driver.findElements(By.xpath("//div[@data-qa='yedexafobi']"));
        Actions action = new Actions(driver);
        action.moveToElement(ViewHeatmap.get(1)).click().perform();
        JVMwait(15000);
        Set<String> allhandles= driver.getWindowHandles();
        System.out.println("all window handle"+ allhandles);
        for (String handle: allhandles){
            if (!handle.equals(parentWindow)){
                driver.switchTo().window(handle);
                driver.switchTo().frame("heatmap-iframe");
                WebElement clickmap= driver.findElement(By.xpath("//div[@data-qa='liqokuxuba']"));
                clickmap.click();

            }
        }



    }
}
