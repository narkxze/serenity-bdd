package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ProductPage extends BasePage{

    @FindBy(id="buy-now-button")
    WebElementFacade buyNowButton;

    @FindBy(id="imgTagWrapperId")
    WebElementFacade productImage;

    @FindBy(name="dropdown_selected_size_name")
    WebElementFacade dropdownSize;

    @FindBy(id="add-to-cart-button")
    WebElementFacade button_addToCart;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void verify() {
        $(productImage).withTimeoutOf(Duration.ofSeconds(15)).waitUntilVisible();
    }

    public void selectValueFromSizeDropdown(int index) {
        $(dropdownSize).selectByIndex(index);
    }

    public void clickAddToCart() {
        waitABit(5000);
        $(button_addToCart).withTimeoutOf(Duration.ofSeconds(10)).click();
    }
}