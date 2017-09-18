package tests;

import org.testng.annotations.Test;
import pages.LandingPage;
import pages.MembersPage;

import static org.testng.Assert.assertTrue;

public class RegisterBankAccountTest extends BaseTest{

    private static String email = "automatic.test@yopmail.com";
    private static String password = "automatic.test";
    private static String wrongAccountNumber = "1111 1111 40 1111111111";
    private static String validAccountNumber = "1111 1111 30 1111111111";
    private static String accountName = "Bank Account Test";
    private static String accountType = "1";

    @Test(description = "test that we can register a bank account")
    public void registerBankAccountTest(){
        LandingPage landingPage = new LandingPage(driver);
        assertTrue(landingPage.isLoaded(), "landing page not loaded");
        MembersPage membersPage = landingPage.validLogin(email, password);
        membersPage.goToAddNewAccountForm();
        assertTrue(membersPage.areFieldsBeingValidated(accountType, wrongAccountNumber, accountName, validAccountNumber), "Fields not being validated");
    }
}