package testData;

import java.util.HashMap;
import java.util.Map;

public class HerOkuAppDatas {

/*
"firstname":"Ahmet",
        "lastname":"Bulut",
        "totalprice":500,
        "depositpaid":false,
        "bookingdates":{
        "checkin":"2021-06-01",
                "checkout":"2021-06-10"
                ,
                "additionalneeds":"wi-fi"

*/
    public static Map<String,Object> reqBodyOlustur(){

        Map<String,Object> reqBodyMap = new HashMap<>();
        Map<String,Object> bookingdatesBodyMap = new HashMap<>();

        bookingdatesBodyMap.put("checkin","2021-06-01");
        bookingdatesBodyMap.put("checkout","2021-06-10");

        reqBodyMap.put("firstname","Ahmet");
        reqBodyMap.put("lastname","Bulut");
        reqBodyMap.put("totalprice",500.0);
        reqBodyMap.put( "depositpaid",false);
        reqBodyMap.put("bookingdates",bookingdatesBodyMap);
        reqBodyMap.put("additionalneeds","wi-fi");



       return reqBodyMap;
    }
    /*
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

     */
    public static Map<String,Object> expBodyOlustur(){
        Map<String,Object> expdataMap = new HashMap<>();

        expdataMap.put("bookingid",24);
        expdataMap.put("booking",reqBodyOlustur());

    return expdataMap;
    }

}
