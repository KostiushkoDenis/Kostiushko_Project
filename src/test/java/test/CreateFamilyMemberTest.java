import baseTest.BaseTest;
import org.junit.Test;


public class CreateFamilyMemberTest extends BaseTest {
    private String year = "2010";
    private String month = "1";
    private final String EDUCATION = "Education";
    private final String FAMILY = "Family";

    private String lastName = "Kostiushko";
    private String firstName = "Vlad";
    private String phone = "+380937709051";



    @Test
    public void addFamilyMember() {
        loginPage.loginWithLoginAndPassword(url,validLogin,validPassword)
                .getMainMenu().goToProfilePersonalData()
                .openModalWindow(FAMILY)
                .inputTextInToLastName(lastName)
                .inputTextInToFirstNam(firstName)
                .inputTextInToPhone(phone)
                .inputTextInToEmail("mail")
                .inputTextInToAddress("Adres1")
                .inputTextInToRegistrationAddress("Adres2")
                .inputTextInToComment("Comment")
                .chooseTheTypeOfFamilyMember("father")
                .chooseDateBirthday(year, month)
                .clickSaveButton()
                .checkFamilyMember(lastName, firstName)
        ;

    }
}
