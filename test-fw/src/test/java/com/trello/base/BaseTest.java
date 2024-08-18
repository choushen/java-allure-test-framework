package com.trello.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.trello.factory.DriverFactory;

public class BaseTest {
    
    protected WebDriver driver;
    private DriverFactory driverFactory = new DriverFactory();

    @BeforeMethod
    public void setup() {
        driver = driverFactory.initDriver(); 
    }

    @AfterMethod
    public void teardown() {
        driverFactory.destroyDriver(driver);
    }

}
