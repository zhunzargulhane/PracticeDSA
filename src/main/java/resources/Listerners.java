package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import org.example.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class Listerners /*extends BaseTest*/ implements ITestListener {
    WebDriver driver;
    static ExtentReports extentReports = resources.ExtentReporter.getReport();
    static ExtentTest extentTest;

    public void onTestStart(ITestResult iTestResult) {
        extentTest = extentReports.createTest(iTestResult.getName());
    }

    public void onTestSuccess(ITestResult iTestResult) {
        extentTest.log(Status.PASS, "This is pass");
    }

    public void onTestFailure(ITestResult iTestResult) {
        extentTest.fail("");
        String name = iTestResult.getName();
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(src, new File("" + name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {
        extentReports.flush();
    }
}
