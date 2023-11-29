package edu.uchicago.step_definitions;

import edu.uchicago.pages.AirtableLoggedInPage;
import edu.uchicago.pages.AirtableLogin;
import edu.uchicago.pages.DestinyImportPage;
import edu.uchicago.utilities.BrowserUtils;
import edu.uchicago.utilities.ConfigurationReader;
import edu.uchicago.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Destiny_stepdefinitions {

    AirtableLoggedInPage airtableLoggedInPage = new AirtableLoggedInPage();
    DestinyImportPage destinyImportPage = new DestinyImportPage();

    @Given("User is on airtable page and logged in")
    public void user_is_on_airtable_page_and_logged_in() {
        Driver.getDriver().get(ConfigurationReader.getProperty("airtableWeb"));
        AirtableLogin.airtableSignIn();

    }

    @When("user click on Destiny Import Project")
    public void user_click_on_destiny_import_project() {
        airtableLoggedInPage.destinyImportProject.click();
    }

    @When("select {string} table")
    public void select_table(String tableName) {
        destinyImportPage.tableSelect(tableName).click();

    }

//    @Then("user should add descriptions to headers")
//    public void user_should_add_descriptions_to_headers() {
//        List<WebElement> allColumns = destinyImportPage.allColumns;
//        for(int i = 1; i< allColumns.size();i++) {
//            String description = destinyImportPage.descriptionSelect(i).getText();
//            allColumns.get(i).click();
//            destinyImportPage.fieldDescriptionButton.click();
//            destinyImportPage.descriptionTextBar.sendKeys(description);
//            destinyImportPage.saveDescriptionButton.click();
//        }
//    }

    @Then("user should add descriptions to headers moving bar with {int}")
    public void user_should_add_descriptions_to_headers_moving_bar_with(Integer xOffset) {
        BrowserUtils.sleep(3);
        List<WebElement> allColumns = destinyImportPage.allColumns;
        System.out.println("allColumns.size() = " + allColumns.size());
        for (int i = 1; i < allColumns.size(); i++) {
            BrowserUtils.sleep(1);
            String description = destinyImportPage.descriptionSelect(i).getText();
            System.out.println(description);
            BrowserUtils.sleep(1);
            allColumns.get(i).click();
            BrowserUtils.sleep(1);
            destinyImportPage.fieldDescriptionButton.click();
            BrowserUtils.sleep(1);
            destinyImportPage.descriptionTextBar.sendKeys(description);
            BrowserUtils.sleep(1);
            destinyImportPage.saveDescriptionButton.click();
            BrowserUtils.sleep(1);

            if (i != allColumns.size() -1 && !(allColumns.get(i+1).isDisplayed())){
                Actions actions = new Actions(Driver.getDriver());
                actions.clickAndHold(destinyImportPage.movingBar).moveByOffset(xOffset,0).release().build().perform();
        }
    }

    }
}