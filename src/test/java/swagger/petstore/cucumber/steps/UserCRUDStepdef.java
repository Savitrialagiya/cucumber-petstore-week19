package swagger.petstore.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import swagger.petstore.crudtest.UserSteps;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class UserCRUDStepdef {

    static ValidatableResponse response;
    static String userName_ = "abcde";


    @Steps
    UserSteps userSteps;

    @When("^I create user with id \"([^\"]*)\" username \"([^\"]*)\" firstname\"([^\"]*)\" lastname\"([^\"]*)\" email\"([^\"]*)\" password\"([^\"]*)\" phone\"([^\"]*)\" userstatus\"([^\"]*)\"$")
    public void iCreateUserWithIdUsernameFirstnameLastnameEmailPasswordPhoneUserstatus(int id, String userName, String firstName, String lastName, String email, String password, String phone, int userStatus) {
        response = userSteps.createUserByUserName(id, userName, firstName, lastName, email, password, phone, userStatus);
    }

    @And("^I verify user created$")
    public void iVerifyUserCreated() {
        //response.statusCode(201);
        userSteps.getUserByUserName(userName_).statusCode(200);
        HashMap<String, ?> newUsername = response.extract().path("");
        Assert.assertTrue(newUsername.containsValue(userName_));
    }

    @And("^I update user with id \"([^\"]*)\" username \"([^\"]*)\" firstname\"([^\"]*)\" lastname\"([^\"]*)\" email\"([^\"]*)\" password\"([^\"]*)\" phone\"([^\"]*)\" userstatus\"([^\"]*)\"$")
    public void iUpdateUserWithIdUsernameFirstnameLastnameEmailPasswordPhoneUserstatus(int id, String username, String firstName, String lastName, String email, String password, String phone, int userStatus) {
        firstName = "Virat";
        response = userSteps.updateUserByUserName(id, username, firstName, lastName, email, password, phone, userStatus);

    }

    @And("^I check user is updated successfully$")
    public void iCheckUserIsUpdatedSuccessfully() {
        response.statusCode(200);
    }

    @And("^I delete user$")
    public void iDeleteUser() {
        userSteps.deleteUserByUserName(userName_);
    }

    @Then("^I verify that user is deleted successfully$")
    public void iVerifyThatUserIsDeletedSuccessfully() {
        userSteps.getUserByUserName(userName_).statusCode(404);
    }
}
