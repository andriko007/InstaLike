package com.andrey007.instalike.screens;

import org.apache.tools.ant.Task;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MainActivityScreen {
    private AndroidDriver driver;


    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/" +
            "android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.HorizontalScrollView/" +
            "android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[2]/android.widget.ImageView")
    private MobileElement tabHeart;

    @AndroidFindBy(id = "com.epplayworld.likes:id/go_link")
    private MobileElement btnEnter;

    @AndroidFindBy(id = "com.epplayworld.likes:id/btnLike")
    private MobileElement btnLike;


    public MainActivityScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }

    public void checkLoading() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(this.btnEnter));

        if (this.tabHeart.isEnabled()) this.tabHeart.click();
    }


    public void cheatLikes() {

        int count = 0;

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(this.btnLike));

        for (; ; ) {
            // System.out.print("AAAA" + this.btnLike.getAttribute("enabled"));
            if (this.btnLike.getAttribute("enabled").equals("true")) {
                System.out.println("BtnLike is enabled: " + this.btnLike.getAttribute("enabled") + " ");
                this.btnLike.click();
                count++;
                System.out.println("Click count: " + count + " Time: " + new SimpleDateFormat("hh:mm:ss a").format(Calendar.getInstance().getTime()));
            }

            if(count >= 300) return;
        }
    }
}
