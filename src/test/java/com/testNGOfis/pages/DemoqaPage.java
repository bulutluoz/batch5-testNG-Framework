package com.testNGOfis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DemoqaPage {
    WebDriver driver;
    public DemoqaPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public String elementiYazdir(int satir, int sutun) {
        // ((//div[@class='rt-tr-group'])[3]//div//div)[5] bu xpath bana 3.satir 5.sutunu veriyor

        WebElement element=driver.findElement(By.xpath("((//div[@class='rt-tr-group'])["+satir+"]//div//div)["+sutun+"]"));
         return element.getText();
    }
}
