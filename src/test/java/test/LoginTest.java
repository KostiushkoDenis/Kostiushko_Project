package test;

import baseTest.BaseTest;
import org.junit.Test;



public class LoginTest extends BaseTest {


    @Test
    public void validLoginTest() {



      loginPage.openLoginPage(url)
              .checkRedirectToLoginPage(url)
              .inputTextInToLoginInput(validLogin)
              .inputTextInToPasswordInput(validPassword)
               .clickLoginButton()
               .checkRedirectToHomePage(url);


    }
}
