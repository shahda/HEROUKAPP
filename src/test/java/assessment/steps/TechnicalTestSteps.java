package assessment.steps;

import assessment.responses.UserIdResponse;
import assessment.utils.ReadData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import assessment.base.BaseAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class TechnicalTestSteps {

    private static Logger logger = LoggerFactory.getLogger(TechnicalTestSteps.class);

    //Request using City
    @When("the request is performed using city \"([^\"]*)\"$")
    public void requestByCity(String city) throws IOException {
        String endpoint = ReadData.readDataFromPropertyFile( "getcity.endpoint")
               + city +"/users";
        BaseAPI.getRequest(endpoint);
    }

    @And ("verify that the response includes the data for \"([^\"]*)\"$")
    public void responseByCity(String city) throws IOException {
        BaseAPI.responseGet.prettyPrint();
        UserIdResponse.assertSuccesfullListUsersbyCity(city);
    }

    //*************************************************************************
    //Request for Instruction
    @When("the request is performed using instructions")
    public void theinstructions() throws IOException {
        String endpoint = ReadData.readDataFromPropertyFile( "getinstrucstions.endpoint");
        BaseAPI.getRequest(endpoint);
    }
    @And ("the response includes the correct message")
    public void theinstructionsresponse() throws IOException {
        BaseAPI.responseGet.prettyPrint();
    }
    //*************************************************************************
    //Request using ID
    @When("the request is performed using user id \"([^\"]*)\"$")
    public void requestById(String id) throws IOException {
        String endpoint = ReadData.readDataFromPropertyFile("getuserbyid.endpoint") + id;
        BaseAPI.getRequest(endpoint);
    }

    @When("the response includes the correct id \"([^\"]*)\"$")
    public void responseValidation(Integer id) throws IOException {
 //       BaseAPI.responseGet.prettyPrint();
        UserIdResponse.assertSuccesfullUserResponsebyId(id);

    }
    //*************************************************************************
    //Request get all users
    @When("the request is performed to get all users")
    public void requestAllUsers() throws IOException {
        String endpoint = ReadData.readDataFromPropertyFile("getlistofusers.endpoint");
        BaseAPI.getRequest(endpoint);
    }

    @And("the response does not include null id field")
    public void assertAllUsersIdNotNull() throws IOException {
        UserIdResponse.assertSuccesfullListUsers();
    }


    @Then("^response should be (\\d+)$")
    public void responseShouldBe(int statusCode) {
        BaseAPI.assertResponseStatus(statusCode);
        logger.info("Response is successful");

      }

} //end of Class