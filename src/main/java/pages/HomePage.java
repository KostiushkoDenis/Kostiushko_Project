package pages;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.MainMenu;

public class HomePage extends ParentPage {
    @FindBy(xpath = ".//* [@class='taskFilters']")
    private WebElement textMyTasksXpath;
    @FindBy(xpath = ".//* [@class='learningHeader']")
    private WebElement areaLearningCoursesAndPathsXpath;
    @FindBy(xpath = ".//* [@class='recommendHeader']")
    private WebElement areaRecommendedXpath;
    private String textMyTasksString = ".//* [@class='taskFilters']";
    private String areaLearningCoursesAndPathsString = ".//* [@class='learningHeader']";
    private String areaRecommendedString = ".//* [@class='recommendHeader']";

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }


    public HomePage checkRedirectToHomePage(String url) {
        checkUrlwithPattern(url, "/");
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(true).withFailMessage("My Task not displayed").isIn(isElementPresent(textMyTasksString));
        softAssertions.assertThat(true).withFailMessage("Area Learning Courses not displayed").isIn(isElementPresent(areaLearningCoursesAndPathsString));
        softAssertions.assertThat(true).withFailMessage("Area Recommended not displayed").isIn(isElementPresent(areaRecommendedString));
        softAssertions.assertAll();
        logger.info("All elements was displayed (Home Page)");
        return this;
    }


    public MainMenu getMainMenu() {
        return new MainMenu(webDriver);
    }

    public PersonalDataPage changeLocalizationOnEN() {
        getMainMenu().goToProfilePersonalData()
                .getProfile().changeLocalizationOnEN();
        return new PersonalDataPage(webDriver);
    }
}
