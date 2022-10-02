package pages.elements;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BadgePage;
import pages.CommonActionsWithElements;
import pages.PersonalDataPage;

public class MainMenu extends CommonActionsWithElements {
    @FindBy (xpath = ".//* [@data-tooltip='Achievements']")
    private WebElement buttonAchievements;
    @FindBy (xpath = ".//a [@class='userSmallInfo' and @href='/Profile']")
    private WebElement goToPersonalProfileButton;

    public MainMenu(WebDriver webDriver) {
        super(webDriver);
    }

    public PersonalDataPage goToProfilePersonalData() {
   clickOnElement(goToPersonalProfileButton);
   logger.info("Go to personal Data button was clicked");
        return new PersonalDataPage(webDriver);
    }


    public BadgePage goToAchievementsBadges() {
        clickOnElement(buttonAchievements);
        return new BadgePage(webDriver);
    }






}
