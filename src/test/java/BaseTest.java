import org.junit.AfterClass;
import org.junit.BeforeClass;
import report.Reporter;

public class BaseTest {

    @BeforeClass
    public static void setUpTest(){
        Reporter.setUpReporter("Get Alerts By Id Test");
    }

    @AfterClass
    public static void tearDownTest(){
        Reporter.report.flush();
    }
}
