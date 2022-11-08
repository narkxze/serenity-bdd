package stepdefs;

import helper.PetStoreSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Shared;

import java.io.File;
import java.util.List;
import java.util.Map;

public class StepDefs {

    @Shared
    PetStoreSteps petStoreSteps;

    @Given("I prepare POST request body with the following parameters")
    public void iCheckThePostBody(DataTable dataTable) {
        List<Map<String,String>> bodyList = dataTable.asMaps(String.class,String.class);
       bodyList.stream().forEach( b -> petStoreSteps.preparePostBody(b));
    }

    @When("I send POST request for {string} endpoint")
    public void sendPostRequest(String endPoint) {
        petStoreSteps.postRequest(endPoint);
    }

    @Then("I save the ID from response for further usage")
    public void saveResponseID() {
        petStoreSteps.saveID();
    }

    @When("I delete the records for the previously created ID")
    public void deleteCreatedRecord() {
        petStoreSteps.deleteRequest();
    }


    @Given("I setup baseURL and preconditions")
    public void iSetupBaseURLAndPreconditions() {
        petStoreSteps.setPreconditions();
    }

    @And("I run GET request for the same ID after deletion")
    public void iRunGETRequestForTheSameIDAfterDeletion() {
        petStoreSteps.getPetInformation();
    }

    @Then("I verify the status code is {int} and message {string}")
    public void iVerifyTheStatusCodeIsAndMessagePetNotFound(int statusCode, String message) {
        petStoreSteps.verifyMessageAndStatusCode(statusCode,message);
    }

    @And("I validate the JSON SCHEMA for the generated ID compared to {string}")
    public void iVerifyTheJSONSCHEMAForTheGeneratedID(String fileName) {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/schemas/"+fileName;
        System.out.println(filePath);
        File file = new File(filePath);
        petStoreSteps.getPetInformation();
        petStoreSteps.verifyJSONSchema(file);
    }
}
