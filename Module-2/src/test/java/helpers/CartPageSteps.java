package helpers;

import pages.CartPage;

public class CartPageSteps {
    CartPage cartPage;
    public void getNavigatedToCartPage() {
        cartPage.verify();
    }

    public boolean checkForSuccessCartMessage() {
        return cartPage.isProductAddedToCart();
    }
}
