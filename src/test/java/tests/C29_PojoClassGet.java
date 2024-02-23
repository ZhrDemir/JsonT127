package tests;

import baseUrl.BaseUrlDummy;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PojoDummyData;
import pojos.PojoDummyExpData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C29_PojoClassGet extends BaseUrlDummy {
/*
   http://dummy.restapiexample.com/api/v1/employee/3 url'ine
   bir GET request gonderdigimizde donen response'un asagidaki gibi oldugunu test edin.

Response Body
// expected data
       {
       "status":"success",
       "data":{
           "id":3,
           "employee_name":"Ashton Cox",
           "employee_salary":86000,
           "employee_age":66,
           "profile_image":""
           },
       "message":"Successfully! Record has been fetched."
       }
    */

    @Test
    public void test(){

        specDummy.pathParams("pp1","employee","pp2","3");

        PojoDummyData dataPOJO = new PojoDummyData(3,"Ashton Cox",86000,66,"");

        PojoDummyExpData expPOJO = new PojoDummyExpData("success","Successfully! Record has been fetched.",dataPOJO);

        Response response = given().spec(specDummy).when().get("{pp1}/{pp2}");

        PojoDummyExpData resPOJO = response.as(PojoDummyExpData.class);

        assertEquals(expPOJO.getStatus(),resPOJO.getStatus());
        assertEquals(expPOJO.getMessage(),resPOJO.getMessage());
        assertEquals(expPOJO.getData().getId(),resPOJO.getData().getId());
        assertEquals(expPOJO.getData().getEmployee_name(),resPOJO.getData().getEmployee_name());
        assertEquals(expPOJO.getData().getEmployee_age(),resPOJO.getData().getEmployee_age());
        assertEquals(expPOJO.getData().getEmployee_salary(),resPOJO.getData().getEmployee_salary());
        assertEquals(expPOJO.getData().getProfile_image(),resPOJO.getData().getProfile_image());





    }

}
