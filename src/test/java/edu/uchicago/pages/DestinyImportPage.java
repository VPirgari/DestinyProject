package edu.uchicago.pages;

import edu.uchicago.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedList;
import java.util.List;

public class DestinyImportPage {

    public DestinyImportPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    public WebElement tableSelect(String tableName){
      return  Driver.getDriver().findElement(By.xpath("//a[.='" + tableName +"']"));
    }

    @FindBy(xpath = "//span[@data-tutorial-selector-id='openColumnMenuButton']")
    public List<WebElement> allColumns;

    @FindBy(xpath = "(//span[@data-tutorial-selector-id='openColumnMenuButton'])[3]")
    public WebElement testElement;

    @FindBy(xpath = "//div[.='Edit field description']")
    public WebElement fieldDescriptionButton;

    @FindBy(xpath = "//div[@class='contentEditableTextbox light-scrollbar rounded col-12 p1']")
    public WebElement descriptionTextBar;

    @FindBy(xpath = "//div[@class='rounded blue text-white py-half px1 link-quiet pointer']")
    public WebElement saveDescriptionButton;

    public WebElement descriptionSelect(int index){
        return Driver.getDriver().findElement(By.xpath("(//div[@data-columnindex='" + index + "'])[2]"));

    }

    @FindBy(xpath = "//div[@class='antiscroll-scrollbar antiscroll-scrollbar-horizontal antiscroll-scrollbar-shown']")
    public WebElement movingBar;
}
