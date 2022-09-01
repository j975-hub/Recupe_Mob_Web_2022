package PageObjects;

import WebUtils.PageUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class LoginPage extends PageUtils {
    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(name = "userType")
    private WebElement  userType;
    @FindBy(xpath = "//input[@name='username']")
    private WebElement userName;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signinButton;

    public void setUserType(String text) throws IOException {
        selectType(userType,text,"userType");
    }
    public void setUserName(String text) throws IOException {
       waitAndSendkeys(userName,text,"userName");
    }
    public void setPassword(String text) throws IOException {
        waitAndSendkeys(password,text,"password");
    }
    public void setSigninButton() throws IOException {
        waitAndClick(signinButton,"siginButton");
    }
}
