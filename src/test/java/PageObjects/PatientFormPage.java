package PageObjects;


import WebUtils.PageUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.io.IOException;

public class PatientFormPage extends PageUtils {
WebDriver driver;
    public PatientFormPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastName;
    @FindBy(xpath = "//div[@class='input-group']")
    private WebElement date;
    private By dataBy = By.xpath("//div[@class='input-group']");
    @FindBy(xpath = "//select[@name='gender']")
    private WebElement gender;
    @FindBy(xpath = "//select[@name='preferredLanguage']")
    private WebElement preferedLanguage;
    @FindBy(xpath = "//input[@name='emailAddress']")
    private WebElement emailID;
    @FindBy(xpath = "//input[@name='confirmEmailAddress']")
    private WebElement confirmEmailID;
    @FindBy(xpath = "//label[text()='Password ']/following-sibling::input[@name='password']")
    private WebElement password;
    @FindBy(xpath = "//label[text()='Confirm Password ']/following-sibling::input[@name='confirmPassword']")
    private WebElement confirmPassword;
    @FindBy(xpath = "//input[@name='mobilePhone']")
    private WebElement mobileNumber;
    @FindBy(xpath = "//label[text()='Type']/following-sibling::ng-select//input[@role='combobox']")
    private WebElement type;
    @FindBy(xpath = "//select[@name='procedureType']")
    private WebElement procedure;
    @FindBy(xpath = "//label[text()='Surgeon']/following-sibling::ng-select//input[@role='combobox']")
    private WebElement surgeon;
    @FindBy(xpath = "//small[text()='Save Patient']/..")
    private WebElement saveButton;
    @FindBy(xpath = "//label[text()='Recupe Coach']/following-sibling::ng-select")
    private WebElement recupeCoach;


    public void setFirstName(String text) throws IOException {
        waitAndSendkeys(firstName,text,"firstName");
    }
    public void setLastName(String text) throws IOException {
        waitAndSendkeys(lastName,text,"lastName");
    }
    public void setGender(String text) throws IOException {
        selectType(gender,text,"gender");
    }
    public void setEmailID(String text) throws IOException {
        waitAndSendkeys(emailID,text,"emailID");
    }
    public void setConfirmEmailID(String text) throws IOException {
        waitAndSendkeys(confirmEmailID,text,"confirmEmailID");
    }
    public void setPassword(String text) throws IOException {
        waitAndSendkeys(password,text,"password");
    }
    public void setConfirmPassword(String text) throws IOException {
        waitAndSendkeys(confirmPassword,text,"confirmPassword");
    }
    public void setMobileNumber(String text) throws IOException {
        waitAndSendkeys(mobileNumber,text,"mobileNumber");
    }
    public void selectSurgeryType(String s) throws InterruptedException {
        type.click();
        WebElement typeOfSurgery= driver.findElement(By.xpath(String.format("//span[text()='%s']",s)));
        typeOfSurgery.click();
    }
    public void selectProcedure(String text) throws IOException {
        selectType(procedure,text,"procedure");
    }
    public void selectSurgeon(String s){
        surgeon.click();
        WebElement surgeonName = driver.findElement(By.xpath(String.format("//span[text()='%s']",s)));
        surgeonName.click();
    }
    public void savePatientForm() throws IOException {
        waitAndClick(saveButton,"saveButton");
    }
    public void selectRecupeCoach(String s){
       recupeCoach.click();
       WebElement recupeCoachName = driver.findElement((By.xpath(String.format("//span[text()='%s']",s))));
       recupeCoachName.click();
    }
}
