package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.File;
import java.io.IOException;

import static enums.Directory.PROJECT_DIR;
import static enums.Directory.REPORT_DIR;

public class Reporter {

    public static ExtentTest myTest;
    private static ExtentHtmlReporter extentHtmlReporter;
    public static ExtentReports report;

    public static void setUpReporter(String suiteName) {
        createReporterDir(REPORT_DIR.getDirectory(), suiteName);
        report = new ExtentReports();

        extentHtmlReporter = new ExtentHtmlReporter(REPORT_DIR.getDirectory() + suiteName + ".html");

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

    public static void fail(String message) {
        myTest.fail(message);
    }

    public static void info(String message) {
        myTest.info(message);
    }

    private static void createReporterDir(String fileDir, String fileName) {
        if (!(new File(fileDir).exists())) {
            try {
                new File(fileDir).mkdirs();
                new File(fileDir + fileName).createNewFile();
            } catch (IOException e) {
                Reporter.info(e.getMessage());
            }
        }
    }

}
