package tests;

import baseUrl.BaseUrlJsonPlaceUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.nullValue;

public class C17_baseUrlJsonPlaceH extends BaseUrlJsonPlaceUrl {



//Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin
@Test
public void get01(){

    /*
  1- https://jsonplaceholder.typicode.com/posts url'ine
   bir GET request yolladigimizda     donen Response'in status kodunun 200
       ve response'ta 100 kayıt old test edin

     */

    //1-url
    specJsonPlaceHolder.pathParam("pp1","posts");

    //2-Expected
    //3-Response
    Response response=given().spec(specJsonPlaceHolder).when().get("/{pp1}");
    //response.prettyPrint();

    response.then().assertThat().statusCode(200)
            .body("title", Matchers.hasSize(100));



    }
    @Test
    public void get02(){
// https://jsonplaceholder.typicode.com/posts/44 endpointine
        //   bir GET request gonderdigimizde donen response’un
        //   status code’unun 200 oldugunu
        //   ve “title” degerinin “optio dolor molestias sit” oldugunu test edin


        //1-url
        specJsonPlaceHolder.pathParams("pp1","posts","pp2",44);

        //3-resp
        Response response = given().spec(specJsonPlaceHolder).when().get("/{pp1}/{pp2}");
        response.prettyPrint();

        response.then().assertThat().statusCode(200)
                .body("title",Matchers.equalTo("optio dolor molestias sit"));




    }
    @Test
    public void get03(){
        // https://jsonplaceholder.typicode.com/posts/50 endpointine
        //   bir Delete request gonderdigimizde donen response’un
        //   status code’unun 200 oldugunu
        //   ve body nin null oldugunu test edin

        specJsonPlaceHolder.pathParams("pp1","posts","pp2",50);

        Response response = given().spec(specJsonPlaceHolder).when().delete("/{pp1}/{pp2}");
        response.prettyPrint();

        response.then().assertThat().statusCode(200)
                .body("title",nullValue());

    }



}
