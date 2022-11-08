package helpers;


import pages.HomePage;

public class HomePageSteps {
    HomePage homePage;

    public void openHomePage() {
        homePage.open();
        homePage.verify();
    }

    public void typeTextInSearchBox(String searchText) {
        homePage.enterTextInSearchBox(searchText);
    }
}
