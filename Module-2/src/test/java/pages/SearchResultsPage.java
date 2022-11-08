package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath="//span[text()='RESULTS']")
    WebElementFacade searchResultsLabel;

    @FindBy(xpath="//div[@data-cel-widget='search_result_2']")
    WebElementFacade firstSearchResult;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void verify() {
        $(searchResultsLabel).withTimeoutOf(Duration.ofSeconds(20)).waitUntilVisible();
    }

    public void clickOnFirstResult() {
//        System.out.println(getDriver().getWindowHandles().size());
        $(firstSearchResult).withTimeoutOf(Duration.ofSeconds(20)).waitUntilVisible().click();
//        getDriver().getWindowHandles().stream().forEach(w -> getDriver().switchTo().window(w));
    }
}
