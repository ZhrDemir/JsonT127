import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C2_Get_ResponseBilgileriAssertion {

     /*
   https://restful-booker.herokuapp.com/booking/83 url'ine bir GET request
   gonderdigimizde donen Response'un,
   status code'unun 200,
   ve content type'inin application/json;
   charset=utf-8, ve Server isimli Header'in degerinin Cowboy,
   ve status Line'in HTTP/1.1 200 OK olduğunu assert ediniz.
*/
@Test
public void get01(){



    // 1-Endpoint belirlenerek hazirlanir
    String url="https://restful-booker.herokuapp.com/booking/10";

    //2-Gerekli ise Expected data hazirlanir
    //3- Request gönderip, dönen response'i kaydetme
    Response response=given().when().get(url);

    //Assertion işlemi yapılır
    response.then()
            .assertThat()
            .statusCode(200)
            .contentType("application/json;charset=utf-8")
            .header("Server","Cowboy")
            .statusLine("HTTP/1.1 200 OK");




}







}
