package com.trello.login;

import org.testng.annotations.Test;
import com.trello.base.BaseTest;
import com.trello.pages.LoginPage;

public class UserTests extends BaseTest {

    @Test
    public void loginToTheApplication() {

        String username = System.getenv("TRELLO_USERNAME");
        String password = System.getenv("TRELLO_PW");

        // Get the singleton instance of LoginPage
        LoginPage loginPage = LoginPage.getInstance();

        // Navigate to login page
        loginPage.navigateToLoginPage(driver.get());

        // Login to the application
        loginPage.login(driver.get(), username, password);

        loginPage.handle2FA(driver.get());

        // Verify user is logged in
        loginPage.verifyLogin(driver.get());

    } // end
} // end
