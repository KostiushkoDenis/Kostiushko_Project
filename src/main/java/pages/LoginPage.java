package pages;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends ParentPage {
    @FindBy(xpath = ".//form [@class]/button [@type='submit']")
    private WebElement signInButtonXpath;
    private String signInButtonString = ".//form [@class]/button [@type='submit']";

    @FindBy(xpath = ".//input[@name='login']")
    private WebElement loginInput;

    @FindBy(xpath = ".//input[@name='password']")
    private WebElement passwordInput;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage openLoginPage(String url) {
        try {
            webDriver.get(url);
            logger.info("Login page was opened");
            logger.info(url);
        } catch (Exception e) {
            logger.error("Can not work with site");
            Assert.fail("Can not work with site");
        }
        return this;
    }

    public HomePage clickLoginButton() {
        clickOnElement(signInButtonXpath);
        return new HomePage(webDriver);
    }


    public LoginPage inputTextInToLoginInput(String login) {
        inputText(login, loginInput);
        return this;
    }

    public LoginPage inputTextInToPasswordInput(String password) {
        inputText(password, passwordInput);
        return this;
    }

    public LoginPage checkRedirectToLoginPage(String url) {
        checkUrlwithPattern(url, "/Account/Login");
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(true).withFailMessage("Button 'Log in' is displayed").isIn(isElementPresent(signInButtonString));
        softAssertions.assertAll();
        logger.info("Login Page open");
        return this;
    }

    public HomePage loginWithLoginAndPassword(String url, String validLogin, String validPassword) {
        openLoginPage(url)
                .inputTextInToLoginInput(validLogin)
                .inputTextInToPasswordInput(validPassword)
                .clickLoginButton()
                .checkRedirectToHomePage(url);

        return new HomePage(webDriver);
    }
}
