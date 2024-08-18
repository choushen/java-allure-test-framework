package com.trello.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
    

    public WebDriver initDriver() {
        try {           
            WebDriver driver;
            String browser;

            browser = System.getProperty("browser");

            if (browser == null) {
                browser = "chrome";
            }

            switch (browser.toLowerCase()) {
                case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                driver = new EdgeDriver(edgeOptions);
                break;

                case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                driver = new FirefoxDriver(firefoxOptions);
                break;

                default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                driver = new ChromeDriver(chromeOptions);
                break;
            }
            return driver;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    } // end

    public void destroyDriver(WebDriver driver) {
        // Clean up the WebDriver instance
        try {
            if(driver != null)
            {
                driver.quit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            driver = null;
        }
    } // end

} // end
