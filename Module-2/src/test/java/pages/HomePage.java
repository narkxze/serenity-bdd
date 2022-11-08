package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class HomePage extends BasePage{

    @FindBy(id="twotabsearchtextbox")
    WebElementFacade searchTextBox;

    @FindBy(id="nav-logo-sprites")
    WebElementFacade amazonLogo;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void verify() {
        getDriver().manage().window().maximize();
        $(amazonLogo).withTimeoutOf(Duration.ofSeconds(20)).waitUntilPresent();
        $(searchTextBox).withTimeoutOf(Duration.ofSeconds(20)).waitUntilPresent();
    }

    public void enterTextInSearchBox(String searchQuery) {
        $(searchTextBox).typeAndEnter(searchQuery);
    }
}
