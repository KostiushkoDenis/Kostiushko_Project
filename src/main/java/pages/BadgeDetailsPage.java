package pages;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

public class BadgeDetailsPage extends ParentPage{
    private  String top10 = ".//*[@class='sc-jLFzpH eSIGIq']";
    private String areaBadge = ".//*[@class='sc-iBkjds dkNMxN base-table__rowwrapper']";
    public BadgeDetailsPage(WebDriver webDriver) {
        super(webDriver);
    }


    public BadgeDetailsPage checkIsRedirectToBadgeDetailsPage(String url) {
        checkUrlwithPattern(url, "/Achievements#/BadgeDetails");
            SoftAssertions softAssertions = new SoftAssertions();
            softAssertions.assertThat(true).withFailMessage("Top 10 not displayed").isIn(isElementPresent(top10));
        softAssertions.assertThat(true).withFailMessage("Area badge not displayed").isIn(isElementPresent(areaBadge));
            softAssertions.assertAll();
            logger.info("Badge Details page was open");
        return this;
    }
}
