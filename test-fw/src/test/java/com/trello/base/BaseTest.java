package com.trello.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.trello.factory.DriverFactory;

public class BaseTest {
    
    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private DriverFactory driverFactory = new DriverFactory();

    @BeforeMethod
    public void setup() {
        WebDriver webDriver = driverFactory.initDriver(); 
        this.driver.set(webDriver);
    }

    @AfterMethod
    public void teardown() {
        if(driver.get() != null) {
            driverFactory.destroyDriver(driver.get());
            driver.remove();
        }
    }

}
