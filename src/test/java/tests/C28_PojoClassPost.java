package tests;

import baseUrl.BaseUrlHerOkuApp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PojoHerOkuAppBookingdates;
import pojos.PojoHerOkuAppExpBody;
import pojos.PojoHerOkuAppReqBody;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C28_PojoClassPost extends BaseUrlHerOkuApp {

    /*
https://restful-booker.herokuapp.com/booking url'ine
asagidaki body'ye sahip bir POST request gonderdigimizde
donen response'un asagidaki gibi oldugunu test edin.
                    Request body
               {
                    "firstname" : "Ahmet",
                    "lastname" : "Bulut",
                    "totalprice" : 500,
                    "depositpaid" : false,
                    "bookingdates" : {
                             "checkin" : "2021-06-01",
                             "checkout" : "2021-06-10"
                                      },
                    "additionalneeds" : "wi-fi"
                }
                   Response Body // expected data
                {
                "bookingid":24,
                "booking":{
                    "firstname":"Ahmet",
                    "lastname":"Bulut",
                    "totalprice":500,
                    "depositpaid":false,
                    "bookingdates":{
                        "checkin":"2021-06-01",
                        "checkout":"2021-06-10"
                    ,
                    "additionalneeds":"wi-fi"
                }
 */

    @Test
    public void test(){

        // 1 - Endpoint ve Req
        specHerOkuApp.pathParam("pp1","booking");

        PojoHerOkuAppBookingdates bookingdatesPOJO = new PojoHerOkuAppBookingdates("2021-06-01","2021-06-10");
        PojoHerOkuAppReqBody reqBodyPOJO = new PojoHerOkuAppReqBody("Ahmet","Bulut",500,false,bookingdatesPOJO,"wi-fi");

        // 2 - Expected Body
        PojoHerOkuAppReqBody bookingPOJO = new PojoHerOkuAppReqBody("Ahmet","Bulut",500,false,bookingdatesPOJO,"wi-fi");
        PojoHerOkuAppExpBody expBodyPoJO = new PojoHerOkuAppExpBody(24,bookingPOJO);

        // 3 - Response
        Response response = given().spec(specHerOkuApp).contentType(ContentType.JSON)
                           .when().body(reqBodyPOJO).post("{pp1}");

        // 4 - Assert
        PojoHerOkuAppExpBody resPOJO = response.as(PojoHerOkuAppExpBody.class);

       // assertEquals(expBodyPoJO.getBookingid(),resPOJO.getBookingid());
        assertEquals(expBodyPoJO.getBooking().getFirstname(),resPOJO.getBooking().getFirstname());
        assertEquals(expBodyPoJO.getBooking().getLastname(),resPOJO.getBooking().getLastname());
        assertEquals(expBodyPoJO.getBooking().getTotalprice(),resPOJO.getBooking().getTotalprice());
        assertEquals(expBodyPoJO.getBooking().getAdditionalneeds(),resPOJO.getBooking().getAdditionalneeds());
        assertEquals(expBodyPoJO.getBooking().isDepositpaid(),resPOJO.getBooking().isDepositpaid());
        assertEquals(expBodyPoJO.getBooking().getBookingdates().getCheckin(),resPOJO.getBooking().getBookingdates().getCheckin());
        assertEquals(expBodyPoJO.getBooking().getBookingdates().getCheckout(),resPOJO.getBooking().getBookingdates().getCheckout());

    }


}
