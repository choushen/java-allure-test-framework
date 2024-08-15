package com.trello.login;

import java.sql.Driver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        

        String username = System.getenv("TRELLO_USERNAME");
        String password = System.getenv("TRELLO_PW");

        driver = driverFactory.initDriver(); 

        driver.get("https://trello.com");
        
        // Login button
        WebElement loginButtonSelector = driver.findElement(By.cssSelector("a[data-uuid='MJFtCCgVhXrVl7v9HA7EH_login']"));
        loginButtonSelector.click();


        // Enter information
        WebElement userEmailInputSelector = driver.findElement(By.cssSelector("#username"));
        userEmailInputSelector.sendKeys(username);

        WebElement continueButtonSelector = driver.findElement(By.cssSelector("#login-submit"));
        continueButtonSelector.click();

        WebElement userPasswordInputSelector = driver.findElement(By.cssSelector("#password"));
        userPasswordInputSelector.sendKeys(password);

        WebElement submitButtonSelector = driver.findElement(By.cssSelector("#login-submit"));
        submitButtonSelector.click();


        // Handle 2FA
        try {
            WebElement button = driver.findElement(By.id("mfa-promote-dismiss"));
            if (button.isDisplayed()) {
                button.click();
            }
        } catch (NoSuchElementException e) {
            // Button is not present, do nothing or handle accordingly
            System.out.println("2FA button is not present... skipping");
        }

        // Verify logged in
        WebElement loginDashboardBoardsListSelector = driver.findElement(By.cssSelector("ul.boards-page-board-section-list"));
        Assert.assertSame(true, loginDashboardBoardsListSelector.isDisplayed());

        driverFactory.destroyDriver(driver);
    }


}
