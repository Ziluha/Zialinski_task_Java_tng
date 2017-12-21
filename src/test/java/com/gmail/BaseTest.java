package com.gmail;

import com.driver.DriverInitQuit;
import com.driver.config.DriverConfig;
import com.pages.factory.PagesFactory;
import com.properties.PropertiesReading;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;
    private DriverInitQuit driverInitQuit;
    private DriverConfig driverConfig;
    protected PagesFactory pages;
    private String browserName;

    @BeforeMethod
    @Parameters("browser")
    public void initTest(String browser){
        driverConfig = new DriverConfig();
        driverInitQuit = new DriverInitQuit();
        driver = driverInitQuit.initDriver(browser);
        driverConfig.loadApp(driver, PropertiesReading.getURLs().getProperty("gmailURL"));
        pages = new PagesFactory(driver);
    }

    @AfterMethod
    public void endTest(){
        driverInitQuit.quitDriver(driver);
    }
}
