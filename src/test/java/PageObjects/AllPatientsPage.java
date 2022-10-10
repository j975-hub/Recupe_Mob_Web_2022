package PageObjects;

import WebUtils.PageUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class AllPatientsPage extends PageUtils {

    public AllPatientsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//table[contains(@class,'table-striped table-hover')]//tbody//tr")
    private WebElement tableBar;
    @FindBy(xpath = "//div[contains(@class,'patient-detail-header')]//i[@class='fas fa-edit']")
    private WebElement patientEditor;
    @FindBy(xpath = "//div[contains(@class,'patient-detail-header')]//i[contains(@class,'fas fa-save text-primary')]")
    private WebElement patientUpdate;

    public void clickOnPatientBar() throws IOException {

        tableBar.click();
        //waitAndClick(tableBar,"tableBar");

    }
    public void clickOnPatientEditButton() throws IOException {
        patientEditor.click();
       // waitAndClick(patientEditor,"patientEditor");
    }
    public void updatePatient() throws IOException {
        waitAndClick(patientUpdate,"patientUpdate");
    }
}
