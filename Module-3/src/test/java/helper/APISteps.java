package helper;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;

import java.util.List;

public class APISteps {
    RequestSpecification preConditions;
    @Step
    public void setPreconditions() {
        preConditions = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                .setContentType(ContentType.JSON).build();
    }
    @Step
    public void verifyStatusCode(String endPoint, int statusCode) {
        SerenityRest
                .given(preConditions)
                .relaxedHTTPSValidation()
                .pathParam("path",endPoint)
                .when()
                .get("/{path}")
                .then()
                .statusCode(statusCode);

    }
    @Step
    public void verifyPetsStatus(String statusOfPets) {

        SerenityRest
                .given()
                .relaxedHTTPSValidation()
                .spec(preConditions).queryParam("status",statusOfPets)
                .when()
                .get("/findByStatus")
                .then()
                .body("status", Matchers.hasItem("available"));
    }
    @Step
    public List<Integer> verifyResponseCount() {
        return SerenityRest
                .then()
                .extract()
                .jsonPath()
                .getList("$");

    }
    @Step
    public void getHeaders(String headers) {
         SerenityRest
                .lastResponse()
                .getHeaders().asList().stream().forEach(System.out::println);
    }
    @Step
    public void verifyHeaders(String headerField, String headerValue) {
        SerenityRest
                .lastResponse()
                .getHeader(headerField).equals(headerValue);
    }

}
