package tests;

import baseUrl.BaseUrlHerOkuApp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C14_BaseUrlHerokuApp extends BaseUrlHerOkuApp {

    //1-  https://restful-booker.herokuapp.com/booking endpointine
//    bir GET request gonderdigimizde
//    donen response'un
//          status code'unun 200 oldugunu
//          ve Response'ta 12 booking oldugunu test edin

    @Test
    public void test01(){

        specHerOkuApp.pathParam("pp1","booking");

        Response response = given().when().spec(specHerOkuApp).get("/{pp1}");

        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasItem(244));



    }

}
