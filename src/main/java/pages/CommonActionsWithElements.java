package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public class CommonActionsWithElements {
    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());

    public WebDriverWait webDriverWait5Second;

    public CommonActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait5Second = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        PageFactory.initElements(webDriver, this);

    }

    protected void clickOnElement(WebElement webElement) {
        try {
            webDriverWait5Second.until(ExpectedConditions.elementToBeClickable(webElement));
            String name = getElementName(webElement);
            webElement.click();
            logger.info("'" + name + " ' was clicked");
        } catch (Exception e) {
            stopTestAndPrintError(e);
        }

    }

    protected void clickOnElement(String xpath) {
        try {
            WebElement element = webDriver.findElement(By.xpath(xpath));
            clickOnElement(element);
        } catch (Exception e) {
            stopTestAndPrintError(e);
        }
    }

    public void inputText(String text, WebElement loginInput) {
        try {
            loginInput.clear();
            loginInput.sendKeys(text);
            logger.info("Text ' " + text + " ' was input");
        } catch (Exception e) {
            stopTestAndPrintError(e);
        }
    }

    private String getElementName(WebElement webElement) {
        try {
            return webElement.getAccessibleName();

        } catch (Exception e) {
            return "";
        }
    }

    public boolean isElementPresent(String locator) {
        try {
            webDriver.findElement(By.xpath(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementPresent(WebElement webElement) {
        try {
            webElement.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void datePicker(String year, String month) {
        clickOnElement(".//* [@class='sc-gkJlnC PsFmH base-datepicker__nav--title']");
        while (!year.equals((webDriver.
                findElement(By.xpath(".//*[@class='sc-gkJlnC PsFmH base-datepicker__nav--title']"))).getText())) {
            clickOnElement(".//*[@class='base-datepicker__nav--arrow']");
        }
        switch (month) {
            case "1":
                clickOnElement(".//*[contains(text(), 'JAN')]");
                break;
            case "2":
                clickOnElement(".//*[contains(text(), 'FEB')]");
                break;
            case "3":
                clickOnElement(".//*[contains(text(), 'MAR')]");
                break;
            case "4":
                clickOnElement(".//*[contains(text(), 'APR')]");
                break;
            case "5":
                clickOnElement(".//*[contains(text(), 'MAY')]");
                break;
            case "6":
                clickOnElement(".//*[contains(text(), 'JUN')]");
                break;
            case "7":
                clickOnElement(".//*[contains(text(), 'JUL')]");
                break;
            case "8":
                clickOnElement(".//*[contains(text(), 'AUG')]");
                break;
            case "9":
                clickOnElement(".//*[contains(text(), 'SEP')]");
                break;
            case "10":
                clickOnElement(".//*[contains(text(), 'OCT')]");
                break;
            case "11":
                clickOnElement(".//*[contains(text(), 'NOV')]");
                break;
            case "12":
                clickOnElement(".//*[contains(text(), 'DEC')]");
                break;
            default:
                Assert.fail("Not valid month");
        }
        clickOnElement(".//div[@class='sc-fHsOPI gsuZid base-datepicker__day--cell base-datepicker__month--current' and contains(text(),'1')]");
    }

    public List<WebElement> getListWebElements(String xpath) {
        return webDriver.findElements(By.xpath(xpath));
    }

    private void stopTestAndPrintError(Exception e) {
        logger.error("Unable to interact with element" + e);
        Assert.fail("Unable to interact with element" + e);
    }
}
