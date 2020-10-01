package com.testNGOfis.test;

import com.testNGOfis.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day03_Test02 extends TestBase {

    //1.”https://www.mediawiki.org/wiki/Download” sayfasina gidin
    // 2.”MediaWiki 1.34.2” dosyasini indirin
    // 3.Dosyanin indirildigini test edin


    @Test
    public void dosyaIndirme(){

        //1.”https://www.mediawiki.org/wiki/Download” sayfasina gidin
        driver.get("https://www.mediawiki.org/wiki/Download");

        // 2.”MediaWiki 1.34.2” dosyasini indirin
        //<a href="https://releases.wikimedia.org/mediawiki/1.35/mediawiki-1.35.0.tar.gz" class="extiw" title="download:mediawiki/1.35/mediawiki-1.35.0.tar.gz">Download MediaWiki 1.35.0</a>
        driver.findElement(By.linkText("Download MediaWiki 1.35.0")).click();

        // 3.Dosyanin indirildigini test edin
        //   Bunun icin ilk once indirilen dosyanin yolunu String olarak kaydetmem gerekiyor
        // C:\Users\lenovo\Downloads\mediawiki-master.tar.gz
        // C:\Users\lenovo  bu kismi javadan aliyorum. System.getProperty("user.home")
        // \Downloads\ downloads yolundan
        // mediawiki-master.tar.gz bu kisim dosyanin adindan

        String dosyaYolu=System.getProperty("user.home")+"\\Downloads\\mediawiki-1.35.0.tar.gz";

        System.out.println(dosyaYolu);

        //C:\Users\lenovo\Downloads\mediawiki-master.tar.gz

        boolean varMi = Files.exists(Paths.get(dosyaYolu));

        Assert.assertTrue(varMi);


    }

}
