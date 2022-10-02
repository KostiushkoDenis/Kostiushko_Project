package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.MainMenu;
import pages.elements.Profile;

import java.util.List;

public class PersonalDataPage extends CommonActionsWithElements {
    public PersonalDataPage(WebDriver webDriver) {
        super(webDriver);
    }

    private String addButton = ".//* [@class='sc-hKMtZM jNccjH sc-ftvSup jLGmKA sc-kNjMHG iSxAEC']";
    @FindBy(xpath = ".//*[@class='sc-kLLXSd hCmzIt']")
    private WebElement closeWindowButton;
    @FindBy(xpath = ".//input [@name='lastName']")
    private WebElement lastNameInputFamily;
    @FindBy(xpath = ".//input [@name='firstName']")
    private WebElement firstNameInputFamily;
    @FindBy(xpath = ".//input [@name='phoneNumber']")
    private WebElement phoneNumberInputFamily;
    @FindBy(xpath = ".//input [@name='email']")
    private WebElement inputEmailFamily;
    @FindBy(xpath = ".//input [@name='employeeActualAddress']")
    private WebElement inputAddressFamily;
    @FindBy(xpath = ".//input [@name='employeeRegistrationAddress']")
    private WebElement inputRegistrationAddressFamily;

    @FindBy(xpath = ".//textarea [@name='comment']")
    private WebElement inputCommentFamily;
    @FindBy(xpath = ".//input [@name='familyMember']")
    private WebElement familyMemberType;

    @FindBy(xpath = ".//*[@name='birthday']")
    private WebElement familyDatePiker;
    @FindBy(xpath = ".//* [contains(text(), 'Save')]")
    private WebElement familySaveButton;


    public PersonalDataPage openModalWindow(String button) {
        List<WebElement> webElements = getListWebElements(addButton);
        clickOnElement(webElements.get(0));
        if (isElementPresent(".//* [contains(text(), '" + button + " Institution')]")) {
            logger.info("Modal Windows Create Education was open");
        } else if (!isElementPresent(".//* [contains(text(), '" + button + " Member') and @class='sc-hlnMnd bmcMTL dropdown__label']")) {
            clickOnElement(closeWindowButton);
            List<WebElement> webElements1 = getListWebElements(addButton);
            clickOnElement(webElements1.get(1));
            logger.info("Modal Windows Create Family was open");
        } else Assert.fail("Not button");
        return this;
    }






    public Profile getProfile() {
        return new Profile(webDriver);
    }

    public PersonalDataPage inputTextInToLastName(String text) {
        inputText(text, lastNameInputFamily);
        return this;
    }

    public PersonalDataPage inputTextInToFirstNam(String text) {
        inputText(text, firstNameInputFamily);
        return this;
    }
    public PersonalDataPage inputTextInToPhone(String text) {
        inputText(text, phoneNumberInputFamily);
        return this;
    }

    public PersonalDataPage inputTextInToEmail(String text) {
        inputText(text, inputEmailFamily);
        return this;
    }
    public PersonalDataPage inputTextInToAddress(String text) {
        inputText(text, inputAddressFamily);
        return this;
    }
    public PersonalDataPage inputTextInToRegistrationAddress(String text) {
        inputText(text, inputRegistrationAddressFamily);
        return this;
    }

    public PersonalDataPage inputTextInToComment(String text) {
        inputText(text, inputCommentFamily);
        return this;
    }


    public PersonalDataPage chooseTheTypeOfFamilyMember(String familyType) {
        String familyTypeNew = familyType.substring(0, 1).toUpperCase() + familyType.substring(1).toLowerCase();
        clickOnElement(familyMemberType);
        clickOnElement(".//*[@id='108550002']");
        return this;
    }


    public PersonalDataPage chooseDateBirthday(String year, String month) {
        clickOnElement(familyDatePiker);
        datePicker(year,month);
        return this;
    }

    public PersonalDataPage clickSaveButton() {
        clickOnElement(familySaveButton);
        return this;
    }

    public PersonalDataPage checkFamilyMember(String date) {
        Assert.assertTrue("Family member not display", isElementPresent(".//*[contains(text(), '"+date+"')]"));
        logger.info("Family member was created");
        return this;
    }
    public MainMenu getMainMenu() {
        return new MainMenu(webDriver);
    }

}
