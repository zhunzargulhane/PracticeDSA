package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    static WebDriver driver;
    @BeforeSuite
    public void initializeDriver(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.acceptInsecureCerts();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.merge(desiredCapabilities);
        driver=new ChromeDriver(chromeOptions);
    }
}
