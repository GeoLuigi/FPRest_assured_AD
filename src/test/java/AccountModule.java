import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AccountModule {

    @Test(priority = 1)
    void getUsers(){
        given()
        .when()
            .get("https://reqres.in/api/users?page=2")
        .then()
            .statusCode(200)
            .body("page", equalTo(2))
            .log().all()
        ;
    }

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
