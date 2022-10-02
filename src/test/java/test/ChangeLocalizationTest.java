package test;

import baseTest.BaseTest;
import org.junit.Test;


public class ChangeLocalizationTest extends BaseTest {

@Test
    public void changeLocalizationEN(){
    loginPage.loginWithLoginAndPassword(url,validLogin,validPassword)
            .getMainMenu().goToProfilePersonalData()
            .getProfile().changeLocalizationOnEN();
}
    @Test
    public void changeLocalizationPL(){
        loginPage.loginWithLoginAndPassword(url,validLogin,validPassword)
                .getMainMenu().goToProfilePersonalData()
                .getProfile().changeLocalizationOnPL();
    }
    @Test
    public void changeLocalizationAZ(){
        loginPage.loginWithLoginAndPassword(url,validLogin,validPassword)
                .getMainMenu().goToProfilePersonalData()
                .getProfile().changeLocalizationOnAZ();
    }
    @Test
    public void changeLocalizationUA(){
        loginPage.loginWithLoginAndPassword(url,validLogin,validPassword)
                .getMainMenu().goToProfilePersonalData()
                .getProfile().changeLocalizationOnUA();
    }
    @Test
    public void changeLocalizationRU(){
        loginPage.loginWithLoginAndPassword(url,validLogin,validPassword)
                .getMainMenu().goToProfilePersonalData()
                .getProfile().changeLocalizationOnRU();
    }
    @Test
    public void changeLocalizationGE(){
        loginPage.loginWithLoginAndPassword(url,validLogin,validPassword)
                .getMainMenu().goToProfilePersonalData()
                .getProfile().changeLocalizationOnGE();
    }

}
