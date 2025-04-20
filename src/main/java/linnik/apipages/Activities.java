package linnik.apipages;

import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Activities {

    private final static String URL = "https://demo.reportportal.io/api/v1/default_personal/dashboard";

    public static HashMap<String, Object> addToken() {
        HashMap<String, Object> token = new HashMap<>();
        token.put("Authorization", "Bearer AlexApi_hJ-tx1mxRQSzw80z7Psj5VR_Rb1TTaj07pmvYFIK9r7izmUFNnXSRjwPPcaX4iHC");
        token.put("Content-type", "application/json");
        return token;
    }

    public static Response postDoAddDashboard(Body body) {
        Response response =
                given()
                        .body(body)
                        .headers(addToken())
                .when()
                        .post(URL);
        return response;
    }
}
