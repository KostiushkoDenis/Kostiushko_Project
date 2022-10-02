package pages;

import org.openqa.selenium.WebDriver;
import pages.elements.Profile;

public class PersonalData extends CommonActionsWithElements{
    public PersonalData(WebDriver webDriver) {
        super(webDriver);
    }


    public Profile getProfile() {
        return new Profile (webDriver);
    }
}
