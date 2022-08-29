package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    WebDriver driver;
    public PageObjectManager(WebDriver driver){
        this.driver=driver;
    }
    public LoginPage LoginPage(){
        LoginPage loginPage = new LoginPage(driver);
        return loginPage;
    }
    public HomePage homePage(){
        HomePage homePage = new HomePage(driver);
        return homePage;
    }
    public PatientFormPage patientFormPage(){
        PatientFormPage patientFormPage = new PatientFormPage(driver);
        return patientFormPage;
    }
}
