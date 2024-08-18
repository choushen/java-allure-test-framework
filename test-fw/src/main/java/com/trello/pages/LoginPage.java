package com.trello.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;


public class LoginPage {
    
    // Properties - Elements
    private Wait<WebDriver> wait;
    private WebDriver loginPageDriver;

    private static final By LOGIN_BUTTON_SELECTOR = By.cssSelector("a[data-uuid='MJFtCCgVhXrVl7v9HA7EH_login']");
    private static final By USERNAME_INPUT_SELECTOR = By.cssSelector("#username");
    private static final By PASSWORD_INPUT_SELECTOR = By.cssSelector("#password");
    private static final By LOGIN_SUBMIT_BUTTON_SELECTOR = By.cssSelector("#login-submit");
    private static final By DASHBOARD_BOARDS_LIST_SELECTOR = By.cssSelector("ul.boards-page-board-section-list");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.loginPageDriver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Methods - Steps

    public void navigateToLoginPage() {
        loginPageDriver.get("https://trello.com");
    }

    public void login(String username, String password) {

                // Click login button
        WebElement loginButton = loginPageDriver.findElement(LOGIN_BUTTON_SELECTOR);
        loginButton.click();

        // Enter username and submit
        WebElement userEmailInput = wait.until(d -> d.findElement(USERNAME_INPUT_SELECTOR));
        userEmailInput.sendKeys(username);

        WebElement loginSubmitButton = loginPageDriver.findElement(LOGIN_SUBMIT_BUTTON_SELECTOR);
        loginSubmitButton.click();

        loginPageDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // Enter password and submit
        WebElement userPasswordInput = wait.until(d -> d.findElement(PASSWORD_INPUT_SELECTOR));
        userPasswordInput.sendKeys(password);

        loginSubmitButton.click(); // Reuse the previously found submit button

    } // login end

    public void handle2FA() {
        try {
            WebElement button = loginPageDriver.findElement(By.id("mfa-promote-dismiss"));
            if (button.isDisplayed()) {
                button.click();
            }
        } catch (NoSuchElementException e) {
            // Button is not present, do nothing or handle accordingly
            System.out.println("2FA button is not present... skipping");
        }
    }

    public void verifyLogin() {
        WebElement loginDashboardBoardsList = wait.until(d -> d.findElement(DASHBOARD_BOARDS_LIST_SELECTOR));
        Assert.assertTrue(loginDashboardBoardsList.isDisplayed(), "Dashboard is not displayed, login might have failed.");
    }

}
