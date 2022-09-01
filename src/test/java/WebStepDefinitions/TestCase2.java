package WebStepDefinitions;

import WebUtils.AlternateClass;
import WebUtils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;

import java.io.IOException;

public class TestCase2 {
    TestContextSetup testContextSetup;
    public TestCase2(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }
    String fileName = "PatientPageFormData";

    @Then("User fill Patient Information")
    public void user_fill_patient_information() throws InterruptedException, IOException {
        try{

            testContextSetup.pageObjectManager.patientFormPage().setFirstName(testContextSetup.getJsonPath(fileName).get("FirstName"));
            testContextSetup.pageObjectManager.patientFormPage().setLastName(testContextSetup.getJsonPath(fileName).get("LastName"));
            new AlternateClass(testContextSetup.driver).setDate();
            testContextSetup.pageObjectManager.patientFormPage().setGender(testContextSetup.getJsonPath(fileName).get("Gender"));
            testContextSetup.pageObjectManager.patientFormPage().setEmailID(testContextSetup.getJsonPath(fileName).get("Email"));
            testContextSetup.pageObjectManager.patientFormPage().setConfirmEmailID(testContextSetup.getJsonPath(fileName).get("ConfirmEmail"));
            testContextSetup.pageObjectManager.patientFormPage().setPassword(testContextSetup.getJsonPath(fileName).get("Password"));
            testContextSetup.pageObjectManager.patientFormPage().setConfirmPassword(testContextSetup.getJsonPath(fileName).get("ConfirmPassword"));
            testContextSetup.pageObjectManager.patientFormPage().setMobileNumber(testContextSetup.getJsonPath(fileName).get("MobilePhone"));
            testContextSetup.pageObjectManager.patientFormPage().selectSurgeryType(testContextSetup.getJsonPath(fileName).get("Type"));
            testContextSetup.pageObjectManager.patientFormPage().selectProcedure(testContextSetup.getJsonPath(fileName).get("Procedure"));
            testContextSetup.pageObjectManager.patientFormPage().selectSurgeon(testContextSetup.getJsonPath(fileName).get("Surgeon"));
            testContextSetup.pageObjectManager.patientFormPage().savePatientForm();
        } catch (Exception e){
           Assert.fail("Fail to fill the Patient Information"+e);
           e.printStackTrace();
        }
    }
    @Then("User validate Patient Information")
    public void user_validate_patient_information() throws InterruptedException, IOException {
        testContextSetup.pageObjectManager.homePage().setAllPatientTab();
        Thread.sleep(5000);
        testContextSetup.pageObjectManager.homePage().searchPatient(testContextSetup.getJsonPath(fileName).get("PatientSearch.PatientName"));
    }
}
