package com.andrey007.instalike;

import com.andrey007.instalike.screens.MainActivityScreen;
import com.andrey007.instalike.screens.StartActivityScreen;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Settings {

    protected AndroidDriver driver;
    AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();

    protected MainActivityScreen mainActivityScreen;
    protected StartActivityScreen startActivityScreen;
   /* protected ConnectDevicesScreen connectDevicesScreen;
    protected MeasurmentsScreen measurmentsScreen;
    protected SurveyScreen surveyScreen;
*/

    @BeforeTest
    public void setUp() throws Exception {

        //File appDir = new File("app/apps");
        //File app = new File(appDir, "Asthma.apk");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "moto_x4");
        caps.setCapability("udid", "ZY22583QC7"); //Give Device ID of your mobile phone
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "8.1.0");
        caps.setCapability("appPackage", "com.epplayworld.likes");
        caps.setCapability("appActivity", "com.epplayworld.likes.StartActivity");
        caps.setCapability("noReset", "false");


        driver =  new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);


        mainActivityScreen = new MainActivityScreen(driver);
        startActivityScreen = new StartActivityScreen(driver);
        service.start();

    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
        service.stop();
    }
}
