import baseTest.BaseTest;
import org.junit.Test;

public class BadgeTest extends BaseTest {

    @Test
    public void BaseBadgeTest(){
        loginPage.loginWithLoginAndPassword(url,validLogin,validPassword)
                .getMainMenu().goToAchievementsBadges()
                .checkRedirectToBadgesPage(url)
                .clickShowAchievedCheckBox()
                .clickOnBadge()
                .checkIsRedirectToBadgeDetailsPage(url);

    }
}
