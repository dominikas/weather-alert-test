import dto.GetAlertByIdResponse;
import org.apache.http.HttpStatus;
import org.junit.Test;
import report.Reporter;
import rest.GetAlerts;
import validations.AlertValidations;

public class NationalWeatherServiceTest extends BaseTest {

    @Test
    public void getAlertByIdPositiveTest() {
        Reporter.myTest = Reporter.report.createTest("getAlertByIdPositiveTest");
        String id = "NWS-IDP-PROD-4371792-3655003";
        GetAlertByIdResponse response = GetAlerts.getAlertById(id, HttpStatus.SC_OK);
        AlertValidations.isGetAlertByIdResponseOkCorrect(response, id);
    }

    @Test
    public void getAlertByIdNotFoundTest() {
        Reporter.myTest = Reporter.report.createTest("getAlertByIdNotFoundTest");
        String id = "xxx";
        GetAlertByIdResponse response = GetAlerts.getAlertById(id, HttpStatus.SC_NOT_FOUND);
        AlertValidations.isGetAlertByIdResponseNotFoundCorrect(response);
    }


}
