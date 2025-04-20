package linnik.APITest;

import io.qameta.allure.Description;
import io.restassured.response.Response;
import linnik.apipages.Activities;
import linnik.apipages.Body;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class APITestDashboard {

    @Test
    @Description("Positive test for adding toolbar")
    public void Test1() {
        Body body = new Body("New Dashboard1");
        Response response = Activities.postDoAddDashboard(body);
        int statusCode = response.getStatusCode();
        Assertions.assertEquals(201, statusCode);
    }

    @Test
    @Description("Negative test for adding toolbar")
    public void Test2() {
        Body body = new Body("");
        Response response = Activities.postDoAddDashboard(body);
        int statusCode = response.getStatusCode();
        Assertions.assertEquals(400, statusCode);
    }
}
