package com.testNGOfis.pages;

import com.testNGOfis.utilities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZeroWebPage {

    WebDriver driver;
    public ZeroWebPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(id="signin_button")
    public WebElement mainsignInButonu;

    @FindBy(id="user_login")
    public WebElement userNameKutusu;

    @FindBy(id="user_password")
    public WebElement passwordKutusu;

    @FindBy(xpath="//input[@name='submit']")
    public WebElement ikincisignIn;

    public void zeroWebLogin(){

        mainsignInButonu.click();
        userNameKutusu.sendKeys(ConfigReader.getProperty("zeroWebKullaniciadi"));
        passwordKutusu.sendKeys(ConfigReader.getProperty("zeroWebPassword"));
        ikincisignIn.click();
    }

}
