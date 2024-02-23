package tests;

import baseUrl.BaseUrlDummy;
import io.restassured.response.Response;
import org.junit.Test;
import testData.DummyData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C25_DeSerializationGET extends BaseUrlDummy {



/*
http://dummy.restapiexample.com/api/v1/employee/3 url’ine
bir GET request gonderdigimizde
donen response’un status code’unun 200,
content Type’inin application/json
ve body’sinin asagidaki gibi oldugunu test edin.
    Expected Response Body
    {
        "status":"success",
        "data":{
                "id":3.0,
                "employee_name":"Ashton Cox",
                "employee_salary":86000.0,
                "employee_age":66.0,
                "profile_image":""
                },
        "message":"Successfully! Record has been fetched."
    }
 */



    @Test
    public void test01(){

        specDummy.pathParams("pp1","employee","pp2",3);

        Map<String,Object> expBodyMap = DummyData.mapBodyOlustur();


        Response response = given().spec(specDummy).when().get("{pp1}/{pp2}");

        Map<String,Object> resMap = response.as(HashMap.class);

        assertEquals(DummyData.basariliSC,response.getStatusCode());
        assertEquals(DummyData.contentType,response.getContentType());

        assertEquals(expBodyMap.get("status"),resMap.get("status"));
        assertEquals(expBodyMap.get("message"),resMap.get("message"));

        assertEquals(((Map)expBodyMap.get("data")).get("id"),((Map)resMap.get("data")).get("id"));
        assertEquals(((Map)expBodyMap.get("data")).get("employee_name"),((Map)resMap.get("data")).get("employee_name"));
        assertEquals(((Map)expBodyMap.get("data")).get("employee_salary"),((Map)resMap.get("data")).get("employee_salary"));
        assertEquals(((Map)expBodyMap.get("data")).get("employee_age"),((Map)resMap.get("data")).get("employee_age"));
        assertEquals(((Map)expBodyMap.get("data")).get("profile_image"),((Map)resMap.get("data")).get("profile_image"));



    }
}
