package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.File;

import static enums.Directory.PROJECT_DIR;

public class Reporter {

    public static ExtentTest myTest;
    private static ExtentHtmlReporter extentHtmlReporter;
    public static ExtentReports report;

    public static void setUpReporter(String suiteName) {
        report = new ExtentReports();
        //todo check if a directory exists
        extentHtmlReporter = new ExtentHtmlReporter(PROJECT_DIR.getDirectory() + "/report/" + suiteName + ".html");

        extentHtmlReporter.loadXMLConfig(
                new File(Reporter.class
                        .getClassLoader()
                        .getResource("extent-config.xml")
                        .getFile()));
        extentHtmlReporter.setAppendExisting(false);
        extentHtmlReporter.start();
        report.attachReporter(extentHtmlReporter);
    }

    public static void pass(String message) {
        myTest.pass(message);
    }
    public static void fail(String message) { myTest.fail(message); }
    public static void info(String message) { myTest.info(message); }
}
