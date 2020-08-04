package rest;

import dto.GetAlertByIdResponse;
import io.restassured.RestAssured;
import report.Reporter;
import utils.Config;

import static io.restassured.RestAssured.given;

public class GetAlerts {

    private static void setUpEndpoint() {
        RestAssured.baseURI = Config.getConfiguration().getUrlApi();
        RestAssured.basePath = "alerts";
        Reporter.info("ENDPOINT " + RestAssured.baseURI + RestAssured.basePath);
    }

    public static GetAlertByIdResponse getAlertById(String id, int expectedStatusCode) {
        GetAlertByIdResponse response = null;
        setUpEndpoint();
        response = given()
                .header("Content-type", "application/json")
                .when()
                .get(id)
                .then()
                .log()
                .all()
                .statusCode(expectedStatusCode)
                .extract()
                .as(GetAlertByIdResponse.class);

        Reporter.info("RESPONSE " + response.toString());
        return response;
    }
}
