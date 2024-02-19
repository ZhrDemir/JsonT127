package tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class C8_JsonPathKullanimi {

/*
{
"firstName": "John",
"lastName": "doe",
"age": 26,
"address": {
    "streetAddress": "naist street",
    "city": "Nara",
    "postalCode": "630-0192"
            },
"phoneNumbers": [
                {
                    "type": "iPhone",
                    "number": "0123-4567-8888"
                },
                {
                    "type": "home",
                    "number": "0123-4567-8910"
                }
                ]
}
 */


@Test
    public void jsonPathKullanimi(){
    JSONObject homeTel = new JSONObject();
    homeTel.put("type","home");
    homeTel.put("number","0123-4567-8910");

    JSONObject iPhoneTel = new JSONObject();
    iPhoneTel.put("type","iPhone");
    iPhoneTel.put("number","0123-4567-8888");

    JSONArray phoneNumbers = new JSONArray();
    phoneNumbers.put(0,iPhoneTel);
    phoneNumbers.put(1,homeTel);

    JSONObject address = new JSONObject();
    address.put("streetAddress", "naist street");
    address.put("city","Nara");
    address.put("postalCode", "630-0192");

    JSONObject personelInfo = new JSONObject();
    personelInfo.put("firstName", "John");
    personelInfo.put("lastName", "doe");
    personelInfo.put("age", 26);
    personelInfo.put("address",address);
    personelInfo.put("phoneNumbers",phoneNumbers);

    System.out.println(personelInfo);
    System.out.println(personelInfo.get("lastName"));
    System.out.println(personelInfo.get("firstName"));
    System.out.println("Adres : "+personelInfo.getJSONObject("address").get("streetAddress")+
            "\n\t\t"+personelInfo.getJSONObject("address").get("postalCode")+
            "\n\t\t"+personelInfo.getJSONObject("address").get("city"));



    System.out.print("Telefon : "+
            personelInfo.getJSONArray("phoneNumbers").getJSONObject(0).get("type"));
    System.out.println(" " +personelInfo.getJSONArray("phoneNumbers").getJSONObject(0).get("number"));
    System.out.print("Telefon : "+
            personelInfo.getJSONArray("phoneNumbers").getJSONObject(1).get("type"));

    System.out.println(" "+
            personelInfo.getJSONArray("phoneNumbers").getJSONObject(1).get("number"));}


}
