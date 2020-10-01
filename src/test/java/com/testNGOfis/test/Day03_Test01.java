package com.testNGOfis.test;

import com.testNGOfis.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day03_Test01 extends TestBase {
    //“http://webdriveruniversity.com/Iframe” sayfasina gidin
    //“Our Products” butonuna basin
    //“Cameras product” I tiklayin
    //Popup mesajini yazdirin
    //“close” butonuna basin
    //"WebdriverUniversity.com (IFrame)" linkini tiklayin
    //"http://webdriveruniversity.com/IFrame/index.html" adresine gittigini test edin


    @Test
    public void iFrame() throws InterruptedException {
        //“http://webdriveruniversity.com/Iframe” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        //“Our Products” butonuna basin
        // Ulasmak istedigimiz our product linkinin iframe icinde oldugunu gorduk
        // bunun icin ilk once iframe i locate edip ona gecis yapmamiz lazim
        WebElement iFrame=driver.findElement(By.id("frame"));
        driver.switchTo().frame(iFrame);

        driver.findElement(By.linkText("Our Products")).click();

        //“Cameras product” I tiklayin
        driver.findElement(By.id("camera-img")).click();

        //Popup mesajini yazdirin

        WebElement popUpyazisi = driver.findElement(By.xpath("//div[@class='modal-body']/p"));
        Thread.sleep(3000);
        System.out.println(popUpyazisi.getText());

        //“close” butonuna basin

        driver.findElement(By.xpath("//*[@class='btn btn-default']")).click();

        //"WebdriverUniversity.com (IFrame)" linkini tiklayin

        driver.switchTo().defaultContent();
        driver.findElement(By.id("nav-title")).click();


        //"http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String aktuelSayfaURL=driver.getCurrentUrl();
        String beklenenSayfaURL="http://webdriveruniversity.com/index.html";

        Assert.assertEquals(aktuelSayfaURL,beklenenSayfaURL);



    }


}
