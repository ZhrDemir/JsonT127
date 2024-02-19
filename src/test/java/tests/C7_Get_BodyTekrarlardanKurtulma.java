package tests;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C7_Get_BodyTekrarlardanKurtulma {


 /*
https://restful-booker.herokuapp.com/booking/10 url'ine bir
GET request gonderdigimizde donen Response'un,
        status code'unun 200,
        ve content type'inin application/json, ve response body'sindeki
        "firstname"in, "Susan",
        ve "lastname"in, "Jackson",
        ve "totalprice"in, 612,
        ve "depositpaid"in, false,
     ve "additionalneeds"in, "Breakfast" oldugunu test edin
 */

    @Test
    public void bodyTekrarindanKurtulma() {
        // 1- Request body ve end-point hazirlama
        String url="https://restful-booker.herokuapp.com/booking/10";

        // 2- Expected Data hazirlama
        // 3- Request gönderip, dönen response'i kaydetme
        Response response =given().when().get(url);
        response.prettyPrint();

        // 4- Assertion
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("firstname", equalTo("Eric"),"lastname",equalTo("Wilson")
                        ,"totalprice",equalTo(866),"depositpaid",equalTo(true),
                        "additionalneeds",equalTo("Breakfast"));


    }
}