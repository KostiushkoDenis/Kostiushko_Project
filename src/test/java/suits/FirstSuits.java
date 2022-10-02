package suits;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BadgeTest.class,
        ChangeLocalizationTest.class,
        CreateFamilyMemberTest.class,
        CreatePraiseTest.class,
        LoginTest.class

})
public class FirstSuits {
}
