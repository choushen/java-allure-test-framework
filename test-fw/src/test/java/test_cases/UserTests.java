package test_cases;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserTests {

    @Test
    public void registerToTheApplication () {

        WebDriver _driver = new ChromeDriver();
        _driver.get("https://mvnrepository.com/artifact/junit/junit/4.13.2");

    }


}
