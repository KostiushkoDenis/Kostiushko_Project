package pages;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BadgePage extends ParentPage{
     @FindBy (xpath = ".//input [@id='toggle']")
    private WebElement showAchievedCheckBoxXpath;
    @FindBy (xpath = ".//* [@id='AchievementsPraises']")
    private WebElement praiseButton;

    private String showAchievedCheckBoxString =".//*[@for='toggle']" ;
    private String areaTOP10 = ".//* [contains(text(), 'Top 10')]";
    private String badge=".//*[@target='_self']";

    public BadgePage(WebDriver webDriver) {
        super(webDriver);
    }

    public BadgePage checkRedirectToBadgesPage(String url) {
        checkUrlwithPattern(url, "/Achievements");
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(true).withFailMessage("Check Box 'Show Achieved' not displayed").isIn(isElementPresent(showAchievedCheckBoxString));
        softAssertions.assertThat(true).withFailMessage("TOP 10 area not displayed").isIn(isElementPresent(areaTOP10));
        softAssertions.assertAll();
        logger.info("All elements was displayed (Badge Page)");
        return this;
    }

    public BadgePage clickShowAchievedCheckBox() {
        clickOnElement(showAchievedCheckBoxString);
        return this;
    }

    public BadgeDetailsPage clickOnBadge() {
        clickOnElement(badge);
        return new BadgeDetailsPage(webDriver);
    }

    public PraisePage goToPraisePage() {
        clickOnElement(praiseButton);
        return new PraisePage(webDriver);
    }
}
