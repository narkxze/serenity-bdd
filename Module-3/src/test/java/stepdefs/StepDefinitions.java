package stepdefs;

import helper.APISteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Shared;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class StepDefinitions {
    @Shared
    APISteps apiSteps;

    @Given("I setup the baseURL and preconditions")
    public void loadURLandPrecons() {
        apiSteps.setPreconditions();
    }

    @Given("I verify the status code of {string} endpoint is {int}")
    public void verifyStatusCode(String endPoint, int statusCode) {
        apiSteps.verifyStatusCode(endPoint, statusCode);
    }

    @Given("I fetch the records of pets that are of {string} status")
    public void fetchStatusOfAllPets(String status) {
        apiSteps.verifyPetsStatus(status);
    }

    @Then("I verify the count of pets are more than {int}")
    public void iVerifyResponseCount(int size) {
        Assert.assertTrue("Response size is lesser than " + size, apiSteps.verifyResponseCount().size() > size);

    }

    @Then("I log the number of pets that has been found in the response")
    public void printCountOfPets() {
        System.out.println("No.of Pets found: " + apiSteps.verifyResponseCount().size());
    }

    @Given("I run GET request for {string} endpoint")
    public void getResponse(String endPoint) {
        apiSteps.getHeaders(endPoint);
    }

    @When("I verify the following response headers")
    public void verifyHeadersFromTheResponse(DataTable headerTable) {
        List<Map<String, String>> headerMaps = headerTable.asMaps(String.class, String.class);
        headerMaps.stream().forEach(map -> map.entrySet().stream().forEach(entry -> apiSteps.verifyHeaders(entry.getKey(), entry.getValue())));

    }

}
