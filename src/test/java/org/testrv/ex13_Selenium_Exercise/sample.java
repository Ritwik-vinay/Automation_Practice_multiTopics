package org.testrv.ex13_Selenium_Exercise;

import org.testng.annotations.Test;
import org.testrv.base.TestSele_Start_End_Browser;

public class sample extends TestSele_Start_End_Browser {
    @Test
    public void ssampleBrowser(){
        driver.getWindowHandle();
        System.out.println(driver.getWindowHandle());

    }
}
