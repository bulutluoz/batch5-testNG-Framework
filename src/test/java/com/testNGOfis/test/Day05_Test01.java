package com.testNGOfis.test;

import com.testNGOfis.pages.DemoqaPage;
import com.testNGOfis.utilities.ConfigReader;
import com.testNGOfis.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Day05_Test01 extends TestBase {

    // 1.” https://demoqa.com/webtables” sayfasina gidin
    // 2. Headers da bulunan department isimlerini yazdirin
    // 3. 3.sutunun basligini yazdirin

    @Test
    public void test01(){
        // 1.” https://demoqa.com/webtables” sayfasina gidin
        driver.get(ConfigReader.getProperty("demoqaURL"));

        // 2. Headers da bulunan department isimlerini yazdirin

        List<WebElement> headerList =driver.findElements(By.xpath("//div[@class='rt-thead -header']"));

        for (WebElement each:headerList
             ) {
            System.out.println(each.getText());
        }

        // 3. 3.sutunun basligini yazdirin

        WebElement header3Sutun = driver.findElement(By.xpath("(//div[@class='rt-th rt-resizable-header -cursor-pointer'])[3]"));
        System.out.println("3.sutun basligi : " + header3Sutun.getText());
    }


    // 4. Tablodaki tum datalari yazdirin
    // 5. Tabloda kac cell (data) oldugunu yazdirin

    @Test
    public void test02(){
        driver.get(ConfigReader.getProperty("demoqaURL"));
        WebElement tableBody = driver.findElement(By.xpath("//div[@class='rt-table']"));
        System.out.println(tableBody.getText());

        List<WebElement> tumHucreler =driver.findElements(By.xpath("//div[@class='rt-td']"));
        for (WebElement each:tumHucreler
             ) {
            System.out.println(each.getText());
        }

        // 5. Tabloda kac cell (data) oldugunu yazdirin

        System.out.println("tablodaki tum hucre sayisi : " + tumHucreler.size());

    }

    // 6. Tablodaki satir sayisini yazdirin
    // 7. Tablodaki sutun sayisini yazdirin
    // 8. Tablodaki 3.kolonu yazdirin
    // 9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin

    @Test
    public void test03(){

     // 6. Tablodaki satir sayisini yazdirin
        driver.get(ConfigReader.getProperty("demoqaURL"));
        List<WebElement> satirlarListesi=driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("Tablodaki Satir Sayisi :  " + satirlarListesi.size());

     // 7. Tablodaki sutun sayisini yazdirin
        List<WebElement> headerList =driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
        System.out.println("Tablodaki sutun sayisi : " + headerList.size());
     // 8. Tablodaki 3.kolonu yazdirin

     // ((//div[@class='rt-tr-group'])[3]//div//div)[5] bu xpath bana 3.satir 5.sutunu veriyor

        // 1.satir 3.sutun
        // 2.satir 3.sutun
        // 3.satir 3.sutun

        // 10.satir 3.sutun


        for (int i=1; i<=satirlarListesi.size();i++){
            WebElement element =driver.findElement(By.xpath("((//div[@class='rt-tr-group'])[" +i+ "]//div//div)[3]"));
            System.out.println(element.getText());
        }
        // 9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin


        int salaryninSutunNumarasi = 0;

        for (int i = 1; i < headerList.size(); i++) {

            if (headerList.get(i).getText().equals("Salary")) {
                salaryninSutunNumarasi = i;
            }
        }
        System.out.println("Salarynin sutun numarasi = " + salaryninSutunNumarasi);

        int kierraSatirSayisi=0;
        for (int i=1;i<satirlarListesi.size();i++){
            // ((//div[@class='rt-tr-group'])[1]//div//div)[1]  1.satirin 1.kolonu

            String elementYolu = "((//div[@class='rt-tr-group'])["+i+"]//div//div)[1]";

            WebElement element = driver.findElement(By.xpath(elementYolu));

            if (element.getText().equals("Kierra")){
                kierraSatirSayisi=i;
            }

        }

        System.out.println("Kierra satir Sayisi = " + kierraSatirSayisi);

        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin

        DemoqaPage demoqaPage=new DemoqaPage(driver);

        int satir=3;
        int sutun=4;

        System.out.println(satir +". satir " + sutun + ". sutundaki element : " + demoqaPage.elementiYazdir(satir,sutun));

    }

}
