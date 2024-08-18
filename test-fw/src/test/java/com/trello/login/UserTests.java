package com.trello.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.trello.base.BaseTest;
import java.time.Duration;

public class UserTests extends BaseTest {

    // CSS Selectors as constants
    private static final By LOGIN_BUTTON_SELECTOR = By.cssSelector("a[data-uuid='MJFtCCgVhXrVl7v9HA7EH_login']");
    private static final By USERNAME_INPUT_SELECTOR = By.cssSelector("#username");
    private static final By PASSWORD_INPUT_SELECTOR = By.cssSelector("#password");
    private static final By LOGIN_SUBMIT_BUTTON_SELECTOR = By.cssSelector("#login-submit");
    private static final By DASHBOARD_BOARDS_LIST_SELECTOR = By.cssSelector("ul.boards-page-board-section-list");

    @Test
    public void loginToTheApplication() {

        // Initialize WebDriverWait
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        String username = System.getenv("TRELLO_USERNAME");
        String password = System.getenv("TRELLO_PW");

        driver.get("https://trello.com");
        
        // Click login button
        WebElement loginButton = driver.findElement(LOGIN_BUTTON_SELECTOR);
        loginButton.click();

        // Enter username and submit
        WebElement userEmailInput = wait.until(d -> d.findElement(USERNAME_INPUT_SELECTOR));
        userEmailInput.sendKeys(username);

        WebElement loginSubmitButton = driver.findElement(LOGIN_SUBMIT_BUTTON_SELECTOR);
        loginSubmitButton.click();

        // Enter password and submit
        WebElement userPasswordInput = wait.until(d -> d.findElement(PASSWORD_INPUT_SELECTOR));
        userPasswordInput.sendKeys(password);

        loginSubmitButton.click(); // Reuse the previously found submit button

        // Handle 2FA if present
        handle2FA();

        // Verify user is logged in
        verifyLogin();
    }

    private void handle2FA() {
        try {
            WebElement button = driver.findElement(By.id("mfa-promote-dismiss"));
            if (button.isDisplayed()) {
                button.click();
            }
        } catch (NoSuchElementException e) {
            // Button is not present, do nothing or handle accordingly
            System.out.println("2FA button is not present... skipping");
        }
    }

    private void verifyLogin() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement loginDashboardBoardsList = wait.until(d -> d.findElement(DASHBOARD_BOARDS_LIST_SELECTOR));
        Assert.assertTrue(loginDashboardBoardsList.isDisplayed(), "Dashboard is not displayed, login might have failed.");
    }
}
