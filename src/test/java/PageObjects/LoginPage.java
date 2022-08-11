package PageObjects;

import WebUtils.PageUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends PageUtils {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
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

    public void setUserType(String text){
        selectUserType(userType,text);
    }
    public void setUserName(String text){
       waitAndSendkeys(userName,text);
    }
    public void setPassword(String text){
        waitAndSendkeys(password,text);
    }
    public void setSigninButton(){
        waitAndClick(signinButton);
    }
}
