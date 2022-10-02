package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.time.Duration;

public class BaseTest extends DataForTest{
    protected WebDriver webDriver;
    public Logger logger = Logger.getLogger(getClass());
    public LoginPage loginPage;


    @Before
    public void beforeTest (){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger.info("Browser wos open");
        loginPage = new LoginPage(webDriver);
        logger.info("Test start");
    }


    @After
    public void afterTest(){
        webDriver.quit();
        logger.info("Browser was closed ");
        logger.info("Test finish");
    }

}
