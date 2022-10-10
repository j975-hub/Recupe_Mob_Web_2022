package PageObjects;

import WebUtils.PageUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage extends PageUtils {
    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//li[@class='nav-item border rounded mr-2']/descendant::a[@href='#/patients']")
    private WebElement allPatientTab;
    @FindBy(xpath = "//small[text()='Add Patient']")
    private WebElement addPatientTab;
    @FindBy(xpath = "//i[contains(@class,'search')]/../../..//input[@type='text']")
    private WebElement patientSearchBox;

    public void setAllPatientTab() throws IOException {
        waitAndClick(allPatientTab,"allPatientTab");
    }
    public void setAddPatientTab() throws IOException {
       waitAndClick(addPatientTab,"addPatientTab");
    }
    public void searchPatient(String text) throws IOException {
        waitAndSendkeys(patientSearchBox,text,"patientSearchBox");
        screenShortOfAllElement("searchPatient");
    }
}
