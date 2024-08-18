package com.trello.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import java.time.Duration;


public class LoginPage extends BasePage {
    
    // Properties - Elements
    private static final By LOGIN_BUTTON_SELECTOR = By.cssSelector("a[data-uuid='MJFtCCgVhXrVl7v9HA7EH_login']");
    private static final By USERNAME_INPUT_SELECTOR = By.cssSelector("#username");
    private static final By PASSWORD_INPUT_SELECTOR = By.cssSelector("#password");
    private static final By LOGIN_SUBMIT_BUTTON_SELECTOR = By.cssSelector("#login-submit");
    private static final By DASHBOARD_BOARDS_LIST_SELECTOR = By.cssSelector("ul.boards-page-board-section-list");

    // Constructor
    private LoginPage() {
        // Set constructor to private to prevent instantiation
    } // end

    // Singleton Helper
    private static class SingletonHelper{
        private static final LoginPage INSTANCE = new LoginPage();
    } // end

    // Singleton Instance
    public static LoginPage getInstance() {
        return SingletonHelper.INSTANCE;
    } // end

    // Methods - Steps

    public void navigateToLoginPage(WebDriver driver) {
        driver.get("https://trello.com");
    } // end

    public void login(WebDriver driver, String username, String password) {

                // Click login button
        WebElement loginButton = driver.findElement(LOGIN_BUTTON_SELECTOR);
        loginButton.click();

        // Enter username and submit
        WebElement userEmailInput = waitForElementToBeVisible(driver, USERNAME_INPUT_SELECTOR, Duration.ofSeconds(5));
        userEmailInput.sendKeys(username);

        WebElement loginSubmitButton = driver.findElement(LOGIN_SUBMIT_BUTTON_SELECTOR);
        loginSubmitButton.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // Enter password and submit
        WebElement userPasswordInput = waitForElementToBeVisible(driver, PASSWORD_INPUT_SELECTOR, Duration.ofSeconds(10));
        userPasswordInput.sendKeys(password);

        loginSubmitButton.click(); // Reuse the previously found submit button

    } // end

    public void handle2FA(WebDriver driver) {
        try {
            WebElement button = driver.findElement(By.id("mfa-promote-dismiss"));
            if (button.isDisplayed()) {
                button.click();
            }
        } catch (NoSuchElementException e) {
            // Button is not present, do nothing or handle accordingly
            System.out.println("2FA button is not present... skipping");
        }
    } // end

    public void verifyLogin(WebDriver driver) {
        WebElement loginDashboardBoardsList = waitForElementToBeVisible(driver, DASHBOARD_BOARDS_LIST_SELECTOR, Duration.ofSeconds(10));
        
        Assert.assertTrue(loginDashboardBoardsList.isDisplayed(), "Dashboard is not displayed, login might have failed.");
    } // end

} // end
