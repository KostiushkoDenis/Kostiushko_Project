package test;

import baseTest.BaseTest;
import libs.Util;
import org.junit.Test;


public class CreateFamilyMemberTest extends BaseTest {
    private String year = "2010";
    private String month = "1";
    private final String EDUCATION = "Education";
    private final String FAMILY = "Family";

    private String lastName = "Kostiushko";
    private String firstName = "Vlad";




    @Test
    public void addFamilyMember() {
        String lastName = Util.getDateAndTimeFormatted();
        loginPage.loginWithLoginAndPassword(url,validLogin,validPassword)
                .changeLocalizationOnEN()
                .openModalWindow(FAMILY)
                .inputTextInToLastName(lastName)
                .inputTextInToFirstNam(firstName)
                .inputTextInToPhone("+380937709051")
                .inputTextInToEmail("mail")
                .inputTextInToAddress("Adres1")
                .inputTextInToRegistrationAddress("Adres2")
                .inputTextInToComment("Comment")
                .chooseTheTypeOfFamilyMember("father")
                .chooseDateBirthday(year, month)
                .clickSaveButton()
                .checkFamilyMember(lastName)
        ;

    }
}
