package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
    static ExtentSparkReporter extentSparkReporter;
    static ExtentReports extentReports=new ExtentReports();
    static ExtentTest extentTest;
    public static ExtentReports getReport(){
        String path=System.getProperty("user.dir")+"\\index.html";
        extentSparkReporter = new ExtentSparkReporter(path);
        extentSparkReporter.config().setDocumentTitle("b");
        extentReports.attachReporter(extentSparkReporter);
        return extentReports;
    }
}
