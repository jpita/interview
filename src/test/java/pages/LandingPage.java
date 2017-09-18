package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by josepita on 13/08/2017.
 */
public class LandingPage extends BasePage {
    @FindBy(xpath = "//input[@value='Accede']")
    private WebElement loginButton;

    @FindBy(name = "birthDateYear")
    private WebElement birthDateYearSelect;

    @FindBy(name = "birthDateMonth")
    private WebElement birthDateMonthSelect;

    @FindBy(name = "birthDateDay")
    private WebElement birthDateDaySelect;

    @FindBy(name = "province")
    private WebElement provinceSelect;

    @FindBy(id = "sso_Email")
    private WebElement emailTxtBx;

    @FindBy(id = "sso_Password")
    private WebElement passwordTxtBx;

    @FindBy(css = "a[href='http://gmail.com']")
    private WebElement goToGmailButton;


    public LandingPage(WebDriver driver) {
        super(driver);
        isLoaded();
    }

    @Override
    public boolean isLoaded() {
        waitForElementToBeVisibleWithTimeOut(loginButton,20);
        return loginButton.isDisplayed();
    }

    public MembersPage validLogin(String email, String password){
        fillLoginInfoAndClickLoginButton(email, password);
        return new MembersPage(driver);
    }

    public void fillLoginInfoAndClickLoginButton(String email, String password){
        emailTxtBx.clear();
        emailTxtBx.sendKeys(email);
        passwordTxtBx.clear();
        passwordTxtBx.sendKeys(password);
        loginButton.click();
    }
}
