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
//    USA CONSOLA CTM!!!! XD
}
