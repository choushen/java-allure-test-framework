package com.trello.login;

import java.sql.Driver;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.trello.factory.DriverFactory;

import io.cucumber.java.AfterAll;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UserTests {

    private WebDriver driver;
    private DriverFactory driverFactory = new DriverFactory();

    @Test
    public void loginToTheApplicaiton () {
        

        driver = driverFactory.initDriver(); 

        driver.get("https://trello.com");

        driverFactory.destroyDriver(driver);

    }


}
