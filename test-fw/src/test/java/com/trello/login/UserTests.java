package com.trello.login;


import org.testng.annotations.Test;
import com.trello.base.BaseTest;
import com.trello.pages.LoginPage;


public class UserTests extends BaseTest {


    @Test
    public void loginToTheApplication() {

        String username = System.getenv("TRELLO_USERNAME");
        String password = System.getenv("TRELLO_PW");

        // Create a new instance of the login page
        LoginPage loginPage = new LoginPage(driver);

        // Navigate to login page
        loginPage.navigateToLoginPage();

        // Login to the application
        loginPage.login(username, password);

        // Verify user is logged in
        loginPage.verifyLogin();

    } // loginToTheApplication end

}
