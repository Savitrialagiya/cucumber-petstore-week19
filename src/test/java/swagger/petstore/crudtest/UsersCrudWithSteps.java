package swagger.petstore.crudtest;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import swagger.petstore.testbase.TestBase;

import java.util.HashMap;

import static swagger.petstore.utils.TestUtils.getRandomDigits;
import static swagger.petstore.utils.TestUtils.getRandomValue;


@RunWith(SerenityRunner.class)
public class UsersCrudWithSteps extends TestBase {

    static int id = getRandomDigits();
    static String username = "Cricket" + getRandomValue();
    static String firstName = "Hardik";
    static String lastName = "Pandya";
    static String email = getRandomValue() + "@gmail.com";
    static String password = "cricket123";
    static String phone = "0123456789";
    static int userStatus = 11;

    @Steps
    UserSteps userSteps;

    @Title("This method will create a new user record")
    @Test
    public void test001() {
        userSteps.createUserByUserName(id, username, firstName, lastName, email, password, phone, userStatus);
    }

    @Title("This method will get and verify existing user record")
    @Test
    public void test002() {
        ValidatableResponse response = userSteps.getUserByUserName(username).statusCode(200);
        HashMap<String, ?> newUsername = response.extract().path("");
        Assert.assertTrue(newUsername.containsValue(username));
    }

    @Title("This method will update and verify an existing user record")
    @Test
    public void test003() {
        firstName = "Virat";
        ValidatableResponse response = userSteps.updateUserByUserName(id, username, firstName, lastName, email, password, phone, userStatus);
        HashMap<String, ?> update = response.extract().path("");
        Integer newId = new Integer(id);
        String id = newId.toString();
        Assert.assertTrue(update.containsValue(id));
    }
    @Title("This method will delete and verify an existing user record")
    @Test
    public void test004() {
        userSteps.deleteUserByUserName(username);
        userSteps.getUserByUserName(username).statusCode(404);
    }

}
