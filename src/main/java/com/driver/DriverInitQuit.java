package com.driver;

import com.reports.eventfiring.EventHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
public class DriverInitQuit {
    private WebDriver driver;

    public WebDriver initDriver(String browserName){
        switch (browserName){
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                driver = startEventFiring(new ChromeDriver());
                return driver;
            case "Firefox":
                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
                driver = startEventFiring(new FirefoxDriver());
                return driver;
        }
        return null;
    }

    private EventFiringWebDriver startEventFiring(WebDriver driver){
        EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
        EventHandler handler = new EventHandler();
        eventDriver.register(handler);
        return eventDriver;
    }

    public void quitDriver(WebDriver driver){
        driver.quit();
    }
}
