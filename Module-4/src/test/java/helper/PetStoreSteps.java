package helper;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.PetStore;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PetStoreSteps {
    PetStore petStore;
    RequestSpecification preConditions;
    Response postResponse;

    @Step
    public void preparePostBody(Map<String, String> body) {
        Map<String, Object> categoryMap = new HashMap<>();

        categoryMap.put("id", body.get("category-id"));
        categoryMap.put("name", body.get("category-name"));

        petStore = PetStore.builder()
                .id(Integer.parseInt(body.get("id")))
                .category(categoryMap)
                .name(body.get("name"))
                .photoUrls(Arrays.asList(body.get("photoUrls").split(",")))
                .tags(Arrays.asList(categoryMap))
                .status(body.get("status"))
                .build();
    }

    @Step
    public void postRequest(String endPoint) {
        postResponse = SerenityRest
                .given()
                .spec(preConditions)
                .relaxedHTTPSValidation()
                .body(petStore)
                .pathParam("path", endPoint)
                .when()
                .post("/{path}")
                .then()
                .extract()
                .response();
    }

    @Step
    public void saveID() {
        Serenity.setSessionVariable("responseID").to(SerenityRest
                .lastResponse()
                .jsonPath()
                .get("id"));

        System.out.println("#####: "+Serenity.sessionVariableCalled("responseID"));
    }

    @Step
    public void deleteRequest() {
        long responseID = Serenity.sessionVariableCalled("responseID");
        SerenityRest
                .given()
                .spec(preConditions)
                .relaxedHTTPSValidation()
                .pathParam("id", responseID)
                .when()
                .delete("/pet/{id}")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("message").equals(responseID);
    }

    @Step
    public void setPreconditions() {
        preConditions = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2")
                .setContentType(ContentType.JSON)
                .build();
    }

    @Step
    public void getPetInformation() {
        long responseID = Serenity.sessionVariableCalled("responseID");
        SerenityRest
                .given()
                .spec(preConditions)
                .relaxedHTTPSValidation()
                .pathParam("id", responseID)
                .when()
                .get("/pet/{id}");
    }
    @Step
    public void verifyMessageAndStatusCode(int statusCode, String message) {
        SerenityRest
                .lastResponse()
                .then()
                .statusCode(statusCode)
                .extract()
                .jsonPath()
                .get("message")
                .equals(message);
    }

    public void verifyJSONSchema(File file) {
        SerenityRest
                .lastResponse()
                .then()
                .body(JsonSchemaValidator.matchesJsonSchema(file));
    }
}
