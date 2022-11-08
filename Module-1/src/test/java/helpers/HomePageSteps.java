package helpers;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import pages.HomePage;

public class HomePageSteps {

    HomePage homePage;

    @Step
    public void openHomePage() {
        homePage.open();
        homePage.getDriver().manage().window().maximize();
    }

    @Step
    public void enterName(String fName, String lName) {
        homePage.enterFirstLastNames(fName,lName);
    }

    @Step
    public void selectValueFromDropdown(String value) {
        homePage.selectValueFromDropdown(value);
    }

    public void imageUpload() {
        homePage.uploadImage();
    }

    public boolean isAutomationChecked() {
        return homePage.isAutomationBoxChecked();
    }

    public void checkAutomationBox() {
        homePage.checkAutomationCheckBox();
    }

    public void moveToSeleniumTab() {
        homePage.moveToElement();
    }
}
