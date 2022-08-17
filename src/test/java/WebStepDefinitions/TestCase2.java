package WebStepDefinitions;

import WebUtils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

public class TestCase2 {
    TestContextSetup testContextSetup;
    public TestCase2(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }
    @And("User will Add patient Tab.")
    public void user_will_click_on_add_patient_tab() throws InterruptedException {
        Thread.sleep(12000);
        testContextSetup.pageObjectManager.homePage().setAllPatientTab();
        Thread.sleep(12000);
        testContextSetup.pageObjectManager.homePage().setAddPatientTab();
    }
}
