package helpers;

import pages.ProductPage;

public class ProductPageSteps {
    ProductPage productPage;
    public void getNavigatedToProductPage() {
        productPage.verify();
    }

    public void selectSizeUsingIndex(int index) {
        productPage.selectValueFromSizeDropdown(index);
    }

    public void clickCart() {
        productPage.clickAddToCart();
    }
}
