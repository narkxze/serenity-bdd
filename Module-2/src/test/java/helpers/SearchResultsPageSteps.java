package helpers;

import pages.SearchResultsPage;

public class SearchResultsPageSteps {
    SearchResultsPage searchResultsPage;
    public void getNavigatedToSearchResultPage() {
        searchResultsPage.verify();
    }

    public void selectFirstOccurenceInResult() {
        searchResultsPage.clickOnFirstResult();
    }
}
