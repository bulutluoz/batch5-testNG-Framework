package com.testNGOfis.test;

import com.github.javafaker.Faker;
import com.testNGOfis.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Set;

public class Day02_Test01 extends TestBase {
    //1."http://webdriveruniversity.com/" adresine gidin
    //2."Login Portal" a  kadar asagi inin
    //3."Login Portal" a tiklayin
    //4.Diger window'a gecin
    //5."username" ve  "password" kutularina rastgele deger yazdirin
    //6."login" butonuna basin
    //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
    //8.Ok diyerek Popup'i kapatin
    //9.Ilk sayfaya geri donun
    //10.Ilk sayfaya donuldugunu test edin

    @Test
    public void windowHandle() throws InterruptedException {
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        String ilkSayfaTitle=driver.getTitle();
        //2."Login Portal" a  kadar asagi inin

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(5000);
        //3."Login Portal" a tiklayin

        driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']")).click();
        //4.Diger window'a gecin

        String ilkSayfaninhandlei= driver.getWindowHandle();
        System.out.println(ilkSayfaninhandlei);
        //3 adimda 2.sayfaya geciyoruz
        // 1) ilk acilis sayfasinin handle'ni bir String variable'a atiyoruz
        // 2) Bir Set olusturup 2 sayfanin handle'larini bu sete koyuyoruz
        // 3) for-each loop ile Set'in icindeki handle'lardan ilksayfanin handle'ina esit olmayana gidiyoruz
        Set<String> tumSayfaHandlelari=driver.getWindowHandles();

        for (String each:tumSayfaHandlelari
             ) {
            if (!each.equals(ilkSayfaninhandlei)){
                driver.switchTo().window(each);
            }
        }

        //5."username" ve  "password" kutularina deger yazdirin
        WebElement usernameKutusu=driver.findElement(By.id("text"));
        Faker faker = new Faker();
        usernameKutusu.sendKeys(faker.name().fullName());

        WebElement passwordKutusu = driver.findElement(By.id("password"));
        passwordKutusu.sendKeys(faker.internet().password());

        Thread.sleep(5000);
        //6."login" butonuna basin
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(5000);
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin

        String aktuelPopUpYazisi=driver.switchTo().alert().getText();
        String beklenenPopUpYazisi="validation failed";

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(aktuelPopUpYazisi,beklenenPopUpYazisi);
        Thread.sleep(5000);
        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        //9.Ilk sayfaya geri donun

        driver.switchTo().window(ilkSayfaninhandlei);
        //10.Ilk sayfaya donuldugunu test edin
        softAssert.assertEquals(driver.getTitle(),ilkSayfaTitle);


        softAssert.assertAll();
    }



}
