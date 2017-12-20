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

    @BeforeTest
    @Parameters("browser")
    public void initBrowser(String browser){
        browserName = browser;
    }

    @BeforeMethod
    public void initTest(){
        driverConfig = new DriverConfig();
        driverInitQuit = new DriverInitQuit();
        driver = driverInitQuit.initDriver(browserName);
        driverConfig.loadApp(driver, PropertiesReading.getURLs().getProperty("gmailURL"));
        pages = new PagesFactory(driver);
    }

    @AfterMethod
    public void endTest(){
        driverInitQuit.quitDriver(driver);
    }
}
