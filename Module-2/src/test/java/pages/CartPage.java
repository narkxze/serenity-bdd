package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class CartPage extends BasePage {

    @FindBy(xpath="//div[contains(@id,'SUCCESS')]//span[contains(text(),'Added to Cart')]")
    WebElementFacade label_addToCartSuccess;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void verify() {
        getDriver().getTitle().contains("Shopping Cart");
    }

    public boolean isProductAddedToCart() {
        return $(label_addToCartSuccess).withTimeoutOf(Duration.ofSeconds(20)).isVisible();
    }

}
