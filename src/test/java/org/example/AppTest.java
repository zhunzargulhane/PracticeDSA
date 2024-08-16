package org.example;

import io.restassured.RestAssured;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjectclasses.HomePage;

import static io.restassured.RestAssured.*;

import java.io.*;
import java.util.Properties;

public class AppTest{
    @Parameters({"UrlDetails"})
    @Test(groups="Aladdin",invocationCount = 1,enabled = true)
    public void browserExecution(String UrlDetails) throws IOException {
        /*Properties properties = new Properties();
        properties.load(new FileReader("src\\com\\data.properties"));
        properties.setProperty("","");
        properties.store(new PrintWriter(""),"data is added");*/

        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.acceptInsecureCerts();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.merge(desiredCapabilities);
        WebDriver driver=new ChromeDriver(chromeOptions);
        HomePage homePage = new HomePage(driver);
        homePage.getSearch().sendKeys("");
        driver.get(UrlDetails);
        driver.quit();
      /*  JavascriptExecutor js= (JavascriptExecutor) driver;
        String script="return document.getElementById('').value";
        String ss=(String)js.executeScript(script);
         WebElement obj=null;

        js.executeScript("argument[0].scrollIntoView(true)",obj);
        SessionId sessionId=((ChromeDriver)driver).getSessionId();
        driver.manage().deleteCookieNamed(new String(String.valueOf(sessionId)));
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src,new File(""));*/

    }
    /*@DataProvider(name="getData")
    public Object[] login(){
        return new Object[][]{{"transactionid","134"},{"transactionid","135"}};
    }

    @Test(dataProvider = "getData",groups = "Login")
    public void useLoginDetails(String id,String value){
        System.out.println(id+" "+value);
    }*/

}