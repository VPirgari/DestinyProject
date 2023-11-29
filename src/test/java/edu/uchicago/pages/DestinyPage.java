package edu.uchicago.pages;

import edu.uchicago.utilities.BrowserUtils;
import edu.uchicago.utilities.ConfigurationReader;
import edu.uchicago.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DestinyPage {

    public DestinyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@autocomplete='username']")
    public WebElement cnetID;

    @FindBy(xpath = "//input[@autocomplete='current-password']")
    public WebElement passworndCnet;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submitCnet;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement sendPush;

    @FindBy(xpath = "//iframe[@frameborder='0']")
    public WebElement framePush;

    @FindBy(id = "logo")
    public WebElement logo;

    @FindBy(id = "caret-down")
    public WebElement mainDrop;

    @FindBy(xpath = "//a[@id='menu-link-EnrolMgr']")
    public WebElement enrolMgr;

    @FindBy(xpath = "//input[@id='studentSurname']")
    public WebElement lastName;

        @FindBy(xpath = "//input[@name='studentGivenName']")
    public WebElement firstName;


    @FindBy(xpath = "//input[@id='email']")
    public WebElement email;

    @FindBy(id = "searchStudent")
    public WebElement searchStudent;

    @FindBy(xpath = "//*[@id=\"studentsResult\"]/tbody/tr[1]/td[2]")
    public WebElement idStudent;

    @FindBy(id = "newSession")
    public  WebElement refresh;


    public void oktaLogin(){
        DestinyPage okta = new DestinyPage();
        okta.cnetID.sendKeys(ConfigurationReader.getProperty("cnet"));
        okta.passworndCnet.sendKeys(ConfigurationReader.getProperty("passwordcnet"));
        okta.submitCnet.click();
//        BrowserUtils.waitVisibilityOf(okta.framePush);
//        Driver.getDriver().switchTo().frame(okta.framePush);
//        okta.sendPush.click();
//        Driver.getDriver().switchTo().defaultContent();
        BrowserUtils.waitVisibilityOf(okta.logo);
    }
}
