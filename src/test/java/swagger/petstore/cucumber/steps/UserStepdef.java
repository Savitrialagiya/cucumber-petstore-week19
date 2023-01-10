package swagger.petstore.cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import swagger.petstore.crudtest.UserSteps;

import java.util.HashMap;

import static swagger.petstore.utils.TestUtils.getRandomDigits;
import static swagger.petstore.utils.TestUtils.getRandomValue;

public class UserStepdef {
    static ValidatableResponse response;
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

    @When("^I sends a GET request to userID endpoint$")
    public void iSendsAGETRequestToUserIDEndpoint() {
        response = userSteps.getUserByUserName(username);
    }

    @Then("^I must get back a valid status code 200$")
    public void iMustGetBackAValidStatusCode() {
        response.statusCode(200);
    }

    @When("^I create new user by providing the information$")
    public void iCreateNewUserByProvidingTheInformation() {
        response = userSteps.createUserByUserName(id, username, firstName, lastName, email, password, phone, userStatus);
    }

    @Then("^I must get a valid status code 201$")
    public void iMustGetAValidStatusCode() {
        response.statusCode(200);
    }

    @When("^I update new user by providing the information$")
    public void iUpdateNewUserByProvidingTheInformation() {
        firstName = "Virat";
        response = userSteps.updateUserByUserName(id, username, firstName, lastName, email, password, phone, userStatus);
        HashMap<String, ?> update = response.extract().path("");
        Integer newId = new Integer(id);
        String id = newId.toString();
        Assert.assertTrue(update.containsValue(id));
    }

    @When("^I delete a DELETE request by providing information$")
    public void iDeleteADELETERequestByProvidingInformation() {
        userSteps.deleteUserByUserName(username);
    }

    @Then("^I verify that the status code$")
    public void iVerifyThatTheStatusCode() {
        userSteps.getUserByUserName(username).statusCode(404);
    }
}
