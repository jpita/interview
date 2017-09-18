package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 */
public class BasePage extends BaseTest{
    private WebDriverWait wait;

    public BasePage(WebDriver driver){
        //in order to have the @FindBy elements being set, we need this line
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public boolean isLoaded() {
        return false;
    }

    protected WebElement waitForElementToBeVisible(WebElement element) {
        return waitForElementToBeVisibleWithTimeOut(element, 5);
    }

    protected WebElement waitForElementToBeVisibleWithTimeOut(WebElement element, int seconds) {
        wait = new WebDriverWait(driver, seconds);
        return wait.until(visibilityOf(element));
    }

    protected Boolean waitForElementToNotBeVisibleWithTimeOut(By by, int seconds) {
        wait = new WebDriverWait(driver, seconds);
        return wait.until(invisibilityOfElementLocated(by));
    }

    protected Boolean waitForElementToNotBeVisible(By by) {
        return waitForElementToNotBeVisibleWithTimeOut(by, 5);
    }


    protected WebElement waitForElementToBeClickableWithTimeOut(By by, int seconds) {
        wait = new WebDriverWait(driver, seconds);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    protected WebElement waitForElementToBeClickable(By by){
        return waitForElementToBeClickableWithTimeOut(by, 5);
    }
}
