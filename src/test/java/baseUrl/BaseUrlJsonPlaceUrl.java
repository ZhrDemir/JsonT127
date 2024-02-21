package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlJsonPlaceUrl {

    protected static RequestSpecification specJsonPlaceHolder;

    @Before
    public void setup(){
        specJsonPlaceHolder=new RequestSpecBuilder().
                setBaseUri("https://jsonplaceholder.typicode.com").build();

    }

}
