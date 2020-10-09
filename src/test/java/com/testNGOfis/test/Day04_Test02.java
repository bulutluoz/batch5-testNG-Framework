package com.testNGOfis.test;

import com.testNGOfis.pages.ZeroWebPage;
import com.testNGOfis.utilities.ConfigReader;
import com.testNGOfis.utilities.TestBase;
import org.testng.annotations.Test;

public class Day04_Test02 extends TestBase {

    //1. configuration file olusturup, oradan data kullanarak http://zero.webappsecurity.com/ 	sayfasina gidin
    //2. Pages package altinda bir zerowebPage classi olusturun
    //3. zerowebPage class'inda login olmak icin gerekli locate'leri ve methodu yazin
    //4. Icinde bulundugumuz class'tan pages sayfasindaki methodu cagirarak login olun


    @Test
    public void logintest(){
        //1. configuration file olusturup, oradan data kullanarak http://zero.webappsecurity.com/ 	sayfasina gidin
       driver.get(ConfigReader.getProperty("zeroWebUrl"));
        //2. Pages package altinda bir ZeroWebPage classi olusturun
        //3. zerowebPage class'inda login olmak icin gerekli locate'leri ve methodu yazin
        ZeroWebPage zeroWebPage = new ZeroWebPage(driver);
        //4. Icinde bulundugumuz class'tan pages sayfasindaki methodu cagirarak login olun
        zeroWebPage.zeroWebLogin();
    }

}
