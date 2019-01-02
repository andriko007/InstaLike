package com.andrey007.instalike.screens;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class StartActivityScreen {

    private AndroidDriver driver;



    @AndroidFindBy(id =  "com.epplayworld.likes:id/autoCompleteTextViewLogin")
    private MobileElement inputLogIn;

    @AndroidFindBy(id =  "com.epplayworld.likes:id/password")
    private MobileElement inputPswrd;

    @AndroidFindBy(id =  "com.epplayworld.likes:id/buttonSignIn")
    private MobileElement btnLogIn;

    public StartActivityScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }

    public void logIn(String login, String password) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(this.inputLogIn));

        this.inputLogIn.click();
        this.inputLogIn.sendKeys(login);

        this.inputPswrd.click();
        this.inputPswrd.sendKeys(password);

        this.btnLogIn.click();

        //if(this.tabHeart.isEnabled()) this.tabHeart.click();
    }
}
