package edu.uchicago.pages;

import edu.uchicago.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AirtableLoggedInPage {

    public AirtableLoggedInPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//a[@aria-label='Destiny Import']")
    public WebElement destinyImportProject;


}
