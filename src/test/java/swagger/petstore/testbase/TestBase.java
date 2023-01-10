package swagger.petstore.testbase;


import io.restassured.RestAssured;
import org.junit.BeforeClass;
import swagger.petstore.constants.Path;
import swagger.petstore.utils.PropertyReader;


public class TestBase {
    public static PropertyReader propertyReader;

    @BeforeClass
    public static void init() {
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");
       // RestAssured.port = Integer.parseInt(propertyReader.getProperty("port"));
        RestAssured.basePath = Path.PETSTORE;
    }

}
