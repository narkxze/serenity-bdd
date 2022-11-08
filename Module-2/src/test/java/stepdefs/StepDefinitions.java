package stepdefs;

import helpers.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.NotImplementedException;
import net.thucydides.core.annotations.Shared;
import org.junit.Assert;
import pages.BasePage;

public class StepDefinitions {
    NavigationSteps navigationSteps;
    @Shared
    CartPageSteps cartSteps;
    @Shared
    HomePageSteps homeSteps;
    @Shared
    ProductPageSteps productSteps;
    @Shared
    SearchResultsPageSteps searchResultsSteps;




    @Given("User opens the Amazon Home Page")
    public void iOpenHomePage() {
        homeSteps.openHomePage();
    }

    @When("user searches {string} in the Search Text Box")
    public void iTypeQueryInSearchBox(String searchText) {
        homeSteps.typeTextInSearchBox(searchText);
    }

    @When("I navigate to the {string} Page")
    public void iNavigateToThePage(String pageValue) {
           switch (pageValue) {
               case "Search Results":
                   searchResultsSteps.getNavigatedToSearchResultPage();
                   break;
               case "Product":
                   productSteps.getNavigatedToProductPage();
                   break;
               case "Cart":
                   cartSteps.getNavigatedToCartPage();
                   break;
               default:
                   throw new NotImplementedException("Page yet to be implemented");
           }
        }
    @When("I click on the first result of the searched item")
    public void iSelectTheFirstResult() {
        int initialWindowCount = navigationSteps.getWindowsCount();
        searchResultsSteps.selectFirstOccurenceInResult();
        int finalWindowCount = navigationSteps.getWindowsCount();
        if(initialWindowCount != finalWindowCount) {
            navigationSteps.switchtoRecentlyOpenedTab();
        }
    }

    @When("I select index {int} from the size dropdown")
    public void iSelectIndexValueFromSizeDropdown(int index) {
        productSteps.selectSizeUsingIndex(index);
    }

    @When("I click on Add to Cart button")
    public void clickOnCartButton() {
        productSteps.clickCart();
    }

    @Then("I verify the item is added to the cart successfully")
    public void checkForSuccessfAddToCartMessage() {
        Assert.assertTrue("Addition of product to the cart is not successful",cartSteps.checkForSuccessCartMessage());
    }
}


