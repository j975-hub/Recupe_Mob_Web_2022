package WebStepDefinitions;

import PageObjects.LoginPage;
import WebUtils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class TestCase1 {
   TestContextSetup testContextSetup;
    public TestCase1(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }
    @Given("User select the User type as {string}")
    public void user_select_the_user_type_as(String text) throws IOException {
        try{
            testContextSetup.pageObjectManager.LoginPage().setUserType(text);
        }catch (Exception e){
            Assert.fail("Fail to select the User Type" + e);
            e.printStackTrace();
        }
    }
    @Then("User will give the credential to sign in the application")
    public void user_will_give_the_credential_to_sign_in_the_applicaton() {
        try{
            testContextSetup.pageObjectManager.LoginPage().setUserName(testContextSetup.baseClass.prop.getProperty("UserName"));
            testContextSetup.pageObjectManager.LoginPage().setPassword(testContextSetup.baseClass.prop.getProperty("Password"));
            testContextSetup.pageObjectManager.LoginPage().setSigninButton();
        }catch (Exception e){
            Assert.fail("Fail to sign in the application" + e);
            e.printStackTrace();
        }
    }
}
