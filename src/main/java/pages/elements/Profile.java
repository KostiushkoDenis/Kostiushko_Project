package pages.elements;

import libs.Util;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActionsWithElements;


public class Profile extends CommonActionsWithElements {
    @FindBy(xpath = ".//*[contains(text(),'EN')]")
    private WebElement buttonEN_Localization;
    @FindBy(xpath = ".//*[contains(text(),'AZ')]")
    private WebElement buttonAZ_Localization;
    @FindBy(xpath = ".//*[contains(text(),'PL')]")
    private WebElement buttonPL_Localization;
    @FindBy(xpath = ".//*[contains(text(),'UA')]")
    private WebElement buttonUA_Localization;
    @FindBy(xpath = ".//*[contains(text(),'RU')]")
    private WebElement buttonRU_Localization;
    @FindBy(xpath = ".//*[contains(text(),'GE')]")
    private WebElement buttonGE_Localization;

    @FindBy(xpath = ".//* [@class='navBurgerIcon']")
    private WebElement buttonNavBurgerMenu;

    @FindBy(xpath = ".//a [@id='ProfilePersonalData']")
    private WebElement buttonPersonalData;

    public Profile(WebDriver webDriver) {
        super(webDriver);
    }


    public Profile changeLocalizationOnEN() {
        clickOnElement(buttonEN_Localization);
        Util.waitABit(1);
        Assert.assertTrue("Localization not change to EN", buttonPersonalData.getText().equals("Personal Data"));
        logger.info("Localization change to EN");
        return this;
    }

    public Profile changeLocalizationOnAZ() {
        clickOnElement(buttonAZ_Localization);
        Util.waitABit(1);
        Assert.assertTrue("Localization not change to AZ", buttonPersonalData.getText().equals("Şəxsi məlumatlar"));
        logger.info("Localization change to AZ");
        return this;
    }

    public Profile changeLocalizationOnPL() {
        clickOnElement(buttonPL_Localization);
        Util.waitABit(1);
        Assert.assertTrue("Localization not change to PL", buttonPersonalData.getText().equals("Dane osobiste"));
        logger.info("Localization change to PL");
        return this;
    }

    public Profile changeLocalizationOnUA() {
        clickOnElement(buttonUA_Localization);
        Util.waitABit(1);
        Assert.assertTrue("Localization not change to UA", buttonPersonalData.getText().equals("Персональні дані"));
        logger.info("Localization change to UA");
        return this;
    }

    public Profile changeLocalizationOnRU() {
        clickOnElement(buttonRU_Localization);
        Util.waitABit(1);
        Assert.assertTrue("Localization not change to RU", buttonPersonalData.getText().equals("Персональные данные"));
        logger.info("Localization change to RU");
        return this;
    }

    public Profile changeLocalizationOnGE() {
        clickOnElement(buttonGE_Localization);
        Util.waitABit(1);
        Assert.assertTrue("Localization not change to GE", buttonPersonalData.getText().equals("პერსონალური მონაცემები"));
        logger.info("Localization change to GE");
        return this;
    }

}
