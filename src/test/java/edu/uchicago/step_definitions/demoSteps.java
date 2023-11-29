package edu.uchicago.step_definitions;

import edu.uchicago.pages.DestinyPage;
import edu.uchicago.utilities.Driver;
import io.cucumber.java.en.Given;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.imageio.stream.FileImageInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class demoSteps {

    DestinyPage destinyPage = new DestinyPage();

    @Given("Show previous automation in Destiny")
    public void show_previous_automation_in_destiny() throws IOException {

        Driver.getDriver().get("https://chicagotestsv.destinysolutions.com/");
        destinyPage.oktaLogin();

        String file = "src/test/resources/xlsFiles/Example.xlsx";
        FileInputStream file1 = new FileInputStream(new File(file));
        Workbook wk = new XSSFWorkbook(file1);
        Sheet sheet = wk.getSheetAt(0);

        destinyPage.mainDrop.click();
        destinyPage.enrolMgr.click();



        for(int i = 5; i < 20; i++) {

            String lastName = String.valueOf(sheet.getRow(i).getCell(2).getStringCellValue());
            String firstName = String.valueOf(sheet.getRow(i).getCell(3).getStringCellValue());;

            destinyPage.lastName.sendKeys(lastName);
            destinyPage.firstName.sendKeys(firstName);

            destinyPage.searchStudent.click();

            String id  = destinyPage.idStudent.getText();

            System.out.println(lastName + " " + firstName + " : " + id);

            destinyPage.refresh.click();



        }

    }
}
