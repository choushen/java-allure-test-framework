package test_cases;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserTests {

    @Test
    public void registerToTheApplication () {
        
        // Automatically manage ChromeDriver binary
        WebDriverManager.chromedriver().setup();


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver _driver = new ChromeDriver(options);
        _driver.get("https://mvnrepository.com/artifact/junit/junit/4.13.2");
        _driver.quit();

    }


}
