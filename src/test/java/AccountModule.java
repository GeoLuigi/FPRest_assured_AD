import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
public class AccountModule {
    @Test(priority = 1)
    void createUser(){
        JSONObject data = new JSONObject();
        data.put("name", "morpheus");
        data.put("job", "leader");

        given()
                .contentType("application/json")
                .body(data)
        .when()
                .post("https://reqres.in/api/users")
        .then()
                .statusCode(201)
                .log().all();
    }
}
