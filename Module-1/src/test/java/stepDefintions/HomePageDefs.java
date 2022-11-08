package stepDefintions;

import helpers.HomePageSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Shared;
import org.junit.Assert;
import pages.HomePage;

public class HomePageDefs {

    @Shared
    HomePageSteps homePageSteps;

    @Given("I navigate to HomePage")
    public void iOpenHomePage() {
        homePageSteps.openHomePage();
    }

   @When("I type first name as {string} and last name as {string}")
    public void iEnterFirstAndLastName(String fName, String lName) {
        homePageSteps.enterName(fName, lName);
   }
   @When("I select {string} from Continents Dropdown")
   public void iSelectValueFromDropdown(String continent) {
    homePageSteps.selectValueFromDropdown(continent);
   }
   @When("I upload a image")
   public void iUploadImage() {
        homePageSteps.imageUpload();
   }

   @When("I verify the automation checkbox is unchecked")
    public void isAutomationCheckboxChecked() {
        Assert.assertFalse("Automation Checkbox is checked",homePageSteps.isAutomationChecked());
        homePageSteps.checkAutomationBox();
       Assert.assertTrue("Automation Checkbox is not checked",homePageSteps.isAutomationChecked());

   }

   @When("I hover over Selenium tab using Actions")
    public void iHoverOverTab() {
        homePageSteps.moveToSeleniumTab();
   }


}
