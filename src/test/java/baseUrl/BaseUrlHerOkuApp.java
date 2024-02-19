package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.*;
import org.junit.Before;

public class BaseUrlHerOkuApp {

    protected static RequestSpecification specHerOkuApp;

    @Before
    public void setup(){
        specHerOkuApp=new RequestSpecBuilder().
                setBaseUri("https://restful-booker.herokuapp.com").build();

    }

}
