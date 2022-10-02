import baseTest.BaseTest;
import libs.Util;
import org.junit.Test;

public class CreatePraiseTest extends BaseTest {

    String data = Util.getDateAndTimeFormatted();
    @Test
    public void createPraise () {
        loginPage.loginWithLoginAndPassword(url,validLogin,validPassword)
                .getMainMenu().goToAchievementsBadges()
                .checkRedirectToBadgesPage(url)
                .goToPraisePage()
                .checkRedirectToPraisePage(url)
                .clickCreatePraiseButton()
                .openCategoryDrobDown()
                .clickOnCategory()
                .openToDrobDown()
                .clickOnSearchInput()
                .inputTextInToSearchInput("SB_Denis")
                .clickOnContact()
                .inputTextInToTextArea(data)
                .clicSendButton()
                .clickOKButtonAfterSendButton()
                .checkPraiseWosCreate(data);
    }

}
