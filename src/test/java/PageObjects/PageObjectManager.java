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
}
