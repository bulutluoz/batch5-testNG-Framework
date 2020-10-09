package com.testNGOfis.test;

import com.testNGOfis.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day04_Test01 extends TestBase {
    //" https://demoqa.com/dynamic-properties” sayfasina gidin
    //“Visible After 5 Seconds” butonunun gorunun oldugunu test edin

    @Test
    public void explicitlyWaitTest(){

    driver.get("https://demoqa.com/dynamic-properties");

        //WebElement besSnSonraGorunen = driver.findElement(By.id("visibleAfter"));

        // Thread.sleep(5000); kodu yazilan sure kadar bekletir
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // WebElement bulununcaya kadar MAX parantez icine yazilan sure kadar bekler
        // TestBase'de implicitly wait komutu yazildiysa test boyunca her webelkement bulunurken beklemeyi yapar

        WebDriverWait wait = new WebDriverWait(driver,10);

        //WebElement bekleyipGoreleman = wait.until(ExpectedConditions.visibilityOf(besSnSonraGorunen));
        WebElement bekleyipGoreleman=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        Assert.assertTrue(bekleyipGoreleman.isDisplayed());


    }
}
