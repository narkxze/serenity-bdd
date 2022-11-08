package pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webelements.Checkbox;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    @FindBy(name="firstname")
    WebElementFacade homePage_firstName;

    @FindBy(name="lastname")
    WebElementFacade homePage_lastName;

    @FindBy(id="continents")
    WebElementFacade homePage_continentsDropdown;

    @FindBy(id="photo")
    WebElementFacade homePage_uploadButton;

    @FindBy(id="profession-1")
    WebElementFacade homePage_automationProfessionCheckBox;

    @FindBy(xpath = "(//a[contains(@href,'selenium-tutorials')])[1]")
     WebElementFacade homePage_seleniumTutLink;

    Checkbox autoTesterCheckBox = new Checkbox(homePage_automationProfessionCheckBox);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void enterFirstLastNames(String fName, String lName) {
        $(homePage_firstName).type(fName);
        $(homePage_lastName).type(lName);
    }

    public void selectValueFromDropdown(String value) {
        $(homePage_continentsDropdown).selectByVisibleText(value);
    }

    public void uploadImage() {
        upload("C:\\Users\\Nareshkarthi_Sakthiv\\Downloads\\MicrosoftTeams-image.png").to(homePage_uploadButton);
    }

    public boolean isAutomationBoxChecked() {
        return autoTesterCheckBox.isChecked();
    }
    public void checkAutomationCheckBox() {
        autoTesterCheckBox.setChecked(true);
    }

    public void moveToElement() {
        withAction().moveToElement(homePage_seleniumTutLink).build().perform();
    }

}
