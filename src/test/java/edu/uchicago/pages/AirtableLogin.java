package edu.uchicago.pages;

import edu.uchicago.utilities.ConfigurationReader;
import edu.uchicago.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AirtableLogin {

    public AirtableLogin() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='https://airtable.com/login']")
    private WebElement signInButton;

    @FindBy(id = "emailLogin")
    private WebElement emailLoginBar;

    @FindBy(xpath = "//button[.='Continue']")
    private WebElement emailContinueButton;

    @FindBy(id = "passwordLogin")
    private WebElement passwordLoginBar;

    @FindBy(xpath = "//button[.='Sign in']")
    private WebElement credentialsSignInButton;


    public static void airtableSignIn() {
        AirtableLogin airtableLogin = new AirtableLogin();
        airtableLogin.signInButton.click();
        airtableLogin.emailLoginBar.sendKeys(ConfigurationReader.getProperty("email"));

//            airtableLogin.emailContinueButton.click();

        airtableLogin.passwordLoginBar.sendKeys(ConfigurationReader.getProperty("password"));
        airtableLogin.credentialsSignInButton.click();
    }

}
