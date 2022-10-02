package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;

public class ParentPage extends CommonActionsWithElements{


    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkUrlwithPattern(String baseUrl, String pageURL ) {
        Assert.assertThat("Invalid page"
                , webDriver.getCurrentUrl()
                , containsString(baseUrl + pageURL));
    }
}
