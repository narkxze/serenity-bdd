package pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

public abstract class BasePage extends PageObject {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    abstract public void verify();

    public int getWindowsCount() {
        return getDriver().getWindowHandles().size();
    }
}
