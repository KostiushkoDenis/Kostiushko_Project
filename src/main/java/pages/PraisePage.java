package pages;

import libs.Util;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PraisePage extends ParentPage {
    @FindBy(xpath =".//* [contains(text(), 'Create praise')]")
    private WebElement createPraiseButton;
    @FindBy(xpath =".//* [contains(text(), 'OK')]")
    private WebElement okButtonAfterSendPraise;
    String textAfterSendPrise = ".//* [contains(text(), 'Your praise is sent')]";
    @FindBy(xpath =".//textarea [@name='text']")
    private WebElement textArea;
    @FindBy(xpath =".//button [@type='submit']")
    private WebElement sendButton;
    @FindBy(xpath =".//* [@class='sc-eirfIE bxmJQa']")
    private WebElement contact;
    @FindBy(xpath =".//input [@type='text' and @placeholder='Search']")
    private WebElement searchInput;
    @FindBy(xpath =".//* [@class='sc-cSizRO gPRHSV']//* [contains(text(), 'Thank you ')]")
    private WebElement thankYouCategory;
    @FindBy(xpath = ".//* [@class='sc-jgqQmc jFDorA']")
    private WebElement areaPraiseCategories;

    @FindBy(xpath = ".//* [@class=\"sc-ewgOdx gIkFSQ\"]")
    private WebElement toButton;
    @FindBy(xpath = ".//* [@class='sc-fvyVFy dsHQmA']")
    private WebElement buttonCategory;

    public PraisePage(WebDriver webDriver) {
        super(webDriver);
    }

    public PraisePage checkRedirectToPraisePage(String url) {
            checkUrlwithPattern(url, "/Achievements#/Praises");
            SoftAssertions softAssertions = new SoftAssertions();
            softAssertions.assertThat(true).withFailMessage("Button  'Create praise' not displayed").isIn(isElementPresent(createPraiseButton));
            softAssertions.assertThat(true).withFailMessage("TOP 10 area not displayed").isIn(isElementPresent(areaPraiseCategories));
            softAssertions.assertAll();
            logger.info("All elements was displayed (Praise Page)");
            return this;
        }

    public PraisePage clickCreatePraiseButton() {
    clickOnElement(createPraiseButton);
        return this;
    }

    public PraisePage openCategoryDrobDown() {
        List<WebElement>  listButton = getListWebElements(".//* [@class='sc-fvyVFy dsHQmA']");
        clickOnElement(listButton.get(0));
        return this;
    }
    public PraisePage openToDrobDown() {
        List<WebElement>  listButton = getListWebElements(".//* [@class='sc-fvyVFy dsHQmA']");
        clickOnElement(listButton.get(1));
        return this;
    }

    public PraisePage clickOnCategory() {
    clickOnElement(thankYouCategory);
        return this;
    }

    public PraisePage clickOnSearchInput() {
        clickOnElement(searchInput);
        return this;
    }

    public PraisePage inputTextInToSearchInput(String contact) {
        inputText(contact, searchInput);
        return this;
    }

    public PraisePage clickOnContact() {
        webDriverWait5Second.until(ExpectedConditions.elementToBeClickable(contact));
    clickOnElement(contact);
    return this;
    }

    public PraisePage inputTextInToTextArea(String comment) {
    inputText(comment, textArea);
    return this;
    }


    public PraisePage clicSendButton() {
clickOnElement(sendButton);
return this;
    }

    public PraisePage clickOKButtonAfterSendButton() {
        Assert.assertTrue("Windows with text 'Your praise is sent' not displayed", isElementPresent(textAfterSendPrise));
        clickOnElement(okButtonAfterSendPraise);
    return this;
    }

    public PraisePage checkPraiseWosCreate(String data) {
        List<WebElement>  listButton = getListWebElements(".//* [contains(text(), '"+data+"')]");
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(false).withFailMessage("More than one Praise created").isIn(listButton.size()==1);
        softAssertions.assertThat(true).withFailMessage("Praise not created").isIn(isElementPresent(".//* [contains(text(), '"+data+"')]"));
        softAssertions.assertAll();
        logger.info("All elements was displayed (Praise Page)");
    return this;
    }
}
