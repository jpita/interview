package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by josepita on 18/09/2017.
 */
public class MembersPage extends BasePage {

    @FindBy(xpath = "//a[@href='/gestion/banking/bank_accounts']")
    private WebElement cuentasBancariasButton;

    @FindBy(xpath = "//div[@class='UIMultiActionButton'][text()='Configurar cuentas bancarias']")
    private WebElement configurarCuentasBancariasButton;

    @FindBy(xpath = "//a[@href='#']/span[text()='Añadir nueva cuenta']")
    private WebElement anadirNuevaCuentaLink;

    @FindBy(id = "bank_account_account_type_id")
    private WebElement typeSelect;

    @FindBy(id = "bank_account_account_number")
    private WebElement bankAccountAccountNumberTxtBx;

    @FindBy(id = "bank_account_account_name")
    private WebElement bankAccountAccountNameTxtBx;

    @FindBy(className = "validation-summary")
    private WebElement validationSummaryLabel;

    @FindBy(css = "#new_bank_account > div.UIPod.pod-white > div > div.UITextbox.presence.length.length_maximum-255.error > span > i")
    private WebElement mandatoryFieldWarningIcon;

    @FindBy(xpath = "//li[text()='Número de cuenta: Cuenta corriente no válida.']")
    private WebElement errorNotificationPanel;

    @FindBy(className = "records")
    private WebElement recordsLabel;

    @FindBy(css = "div.UIDialog.medium.modal span.UIButton button.save.button.primary")
    private WebElement saveButton;

    private int originalNumberOfRecords;

    public MembersPage(WebDriver driver) {
        super(driver);
        isLoaded();
    }

    @Override
    public boolean isLoaded() {
        waitForElementToBeVisibleWithTimeOut(cuentasBancariasButton,20);
        return cuentasBancariasButton.isDisplayed();
    }

    public Boolean areFieldsBeingValidated(String accountType, String wrongAccountNumber, String accountName, String validAccountNumber){
        /*
        * select account type
        * insert wrong account number
        * click save
        * check for presence of mandatoryFieldWarningIcon and validationSummaryLabel
        * insert account name
        * click save
        * check for presence of errorNotificationPanel at the bottom of the page
        * insert valid account number
        * click save
        * check the originalNumberOfRecords is +1
        * */
        selectAccountType(accountType);
        fillAccountNumber(wrongAccountNumber);
        saveButton.click();
        waitForElementToBeVisibleWithTimeOut(mandatoryFieldWarningIcon, 1);
        waitForElementToBeVisibleWithTimeOut(validationSummaryLabel, 1);

        fillAccountName(accountName);
        saveButton.click();
        waitForElementToBeVisibleWithTimeOut(errorNotificationPanel, 5);

        fillAccountNumber(validAccountNumber);
        saveButton.click();
        waitForElementToNotBeVisibleWithTimeOut(By.xpath("//li[text()='Número de cuenta: Cuenta corriente no válida.']"), 5);

        //this thread sleep is here because the number or records takes a while to update
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return Integer.parseInt(recordsLabel.getText()) == originalNumberOfRecords+1;

    }

    public void goToAddNewAccountForm(){
        cuentasBancariasButton.click();
        configurarCuentasBancariasButton.click();
        anadirNuevaCuentaLink.click();
        waitForElementToBeVisibleWithTimeOut(recordsLabel, 10);
        originalNumberOfRecords = Integer.parseInt(recordsLabel.getText());

    }

    private void selectAccountType(String value){
        Select select = new Select(typeSelect);
        select.selectByValue(value);
    }

    private void fillAccountNumber(String value){
        bankAccountAccountNumberTxtBx.clear();
        bankAccountAccountNumberTxtBx.sendKeys(value);
    }

    private void fillAccountName(String value){
        bankAccountAccountNameTxtBx.clear();
        bankAccountAccountNameTxtBx.sendKeys(value);
    }
}
