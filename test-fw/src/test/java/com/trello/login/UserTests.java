package com.trello.login;

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
    

    @Test
    public void loginToTheApplicaiton () {
        

        driver = new DriverFactory().initDriver(); 

        driver.get("https://trello.com");

        DriverFactory.driverFactory.cleanDriver(driver);

    }


}
