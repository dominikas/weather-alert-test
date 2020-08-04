package validations;

import dto.GetAlertByIdResponse;
import org.junit.Assert;
import report.Reporter;

public class AlertValidations {

    public static void isGetAlertByIdResponseOkCorrect(GetAlertByIdResponse response, String id) {
        try {
            Assert.assertTrue("Response does not contain expected id", response.getId().contains(id));
            Assert.assertEquals("Response does not contain expected type Feature", "Feature", response.getType());
        } catch (AssertionError e) {
            Reporter.fail(e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public static void isGetAlertByIdResponseNotFoundCorrect(GetAlertByIdResponse response) {
        try {
            Assert.assertEquals("Response does not expected status", 404, response.getStatus());
            Assert.assertEquals("Response does not contain expected title", "Not Found", response.getTitle());
        } catch (AssertionError e) {
            Reporter.fail(e.getMessage());
            Assert.fail(e.getMessage());
        }
    }
}
