package helpers;

import com.fasterxml.jackson.databind.ser.Serializers;
import net.thucydides.core.annotations.Shared;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.util.stream.Collectors;

public class NavigationSteps extends PageObject {

    public NavigationSteps (WebDriver driver) {
        super(driver);
    }

    public int getWindowsCount() {
        return getDriver().getWindowHandles().size();
    }

    public void switchtoRecentlyOpenedTab() {
        getDriver().getWindowHandles().stream().forEach(w -> getDriver().switchTo().window(w));
    }

}
