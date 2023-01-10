package swagger.petstore.crudtest;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import swagger.petstore.testbase.TestBase;
import swagger.petstore.utils.PropertyReader;


@UseTestDataFrom("src/test/java/resources/testdata/user.csv")
@RunWith(SerenityParameterizedRunner.class)
public class DataDrivenTest extends TestBase {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;

    @Steps
    UserSteps userSteps;

    @Title("Data driven test for adding multiple users")
    @Test
    public void createMultipleUsers() {
        userSteps.createUserByUserName(id,username,firstName,lastName,email,password,phone,userStatus).statusCode(200);
    }

}
