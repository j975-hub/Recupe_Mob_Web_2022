package PageObjects;

import WebUtils.PageUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageUtils {
    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "(//a[@class='nav-link text-white p-1'])[2]")
    private WebElement allPatientTab;
    @FindBy(xpath = "//small[text()='Add Patient']")
    private WebElement addPatientTab;

    public void setAllPatientTab(){
        waitAndClick(allPatientTab);
    }
    public void setAddPatientTab(){
        waitAndClick(addPatientTab);
    }
}
