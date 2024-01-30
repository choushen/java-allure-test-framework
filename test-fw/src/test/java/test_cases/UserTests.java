package test_cases;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UserTests {

    @Test
    public void registerToTheApplication () {

        // Site I'll be testing against
        // https://documenter.getpostman.com/view/4012288/TzK2bEa8#intro
        // https://thinking-tester-contact-list.herokuapp.com/

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver _driver = new ChromeDriver(options);
        _driver.get("https://mvnrepository.com/artifact/junit/junit/4.13.2");
        _driver.quit();

    }


}
