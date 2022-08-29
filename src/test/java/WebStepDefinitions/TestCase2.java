package WebStepDefinitions;

import WebUtils.AlternateClass;
import WebUtils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

public class TestCase2 {
    TestContextSetup testContextSetup;
    public TestCase2(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }


    @Then("User fill Patient Information")
    public void user_fill_patient_information() throws InterruptedException {

        testContextSetup.pageObjectManager.patientFormPage().setFirstName("Sara");
        testContextSetup.pageObjectManager.patientFormPage().setLastName("Racher");
        new AlternateClass(testContextSetup.driver).setDate();



    }
}
