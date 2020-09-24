package com.testNGOfis.test;

import com.testNGOfis.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Day01_Test02 extends TestBase {

    // 1."http://webdriveruniversity.com/Actions" sayfasina gidin
    // 2."Hover over Me First" kutusunun ustune gelin
    // 3."Link 1" e tiklayin
    // 4.Popup mesajini yazdirin
    // 5.Popup'i tamam diyerek kapatin
    // 6."Click and hold" kutusuna basili tutun
    // 7. "Click and hold" kutusunda cikan yaziyi yazdirin
    // 8. "Double click me" butonunu cift tiklayin

    @Test
    public void test01(){
        //1."http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2."Hover over Me First" kutusunun ustune gelin
        WebElement hoverOverMeButonu = driver.findElement(By.xpath("//div[@class='dropdown hover']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(hoverOverMeButonu).perform();

        //3."Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[@class='list-alert'])[1]")).click();

        //4.Popup mesajini yazdirin
        String popUpYazisi=driver.switchTo().alert().getText();
        System.out.println("Popup Yazisi : " + popUpYazisi);

        //5.Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6."Click and hold" kutusuna basili tutun
        WebElement clickAndHoldKutusu = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHoldKutusu).perform();

        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHoldKutusu.getText());

        //8. "Double click me" butonunu cift tiklayin
        WebElement doubleClickKutusu = driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleClickKutusu).perform();

    }
}
