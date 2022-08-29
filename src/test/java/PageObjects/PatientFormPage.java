package PageObjects;


import WebUtils.PageUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;

public class PatientFormPage extends PageUtils {
WebDriver driver;
    public PatientFormPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastName;
    @FindBy(xpath = "//div[@class='input-group']") //(//div[@class='input-group'])[1]
    private WebElement date;
    private By dataBy = By.xpath("//div[@class='input-group']");         //  (//div[@class='input-group']);
    @FindBy(xpath = "//select[@name='gender']")
    private WebElement gender;
    @FindBy(xpath = "//select[@name='preferredLanguage']")
    private WebElement preferedLanguage;
    @FindBy(xpath = "//input[@name='emailAddress']")
    private WebElement emailID;
    @FindBy(xpath = "//input[@name='confirmEmailAddress']")
    private WebElement confirmEmailID;
    @FindBy(xpath = "(//input[@name='password'])[2]")
    private WebElement password;
    @FindBy(xpath = "(//input[@name='confirmPassword'])[2]")
    private WebElement confirmPassword;
    @FindBy(xpath = "//input[@name='mobilePhone']")
    private WebElement mobileNumber;
    @FindBy(xpath = "//span[text()='Non-Surgical']")
    private WebElement typeOfSurgery;
    @FindBy(xpath = "//select[@name='procedureType']")
    private WebElement procedure;
    @FindBy(xpath = "//span[text()='Dr. Albert, Jeffrey']")
    private WebElement surgeon;
    @FindBy(xpath = "//small[text()='Save Patient']")
    private WebElement saveButton;

    public void setFirstName(String text){
        waitAndSendkeys(firstName,text);
    }
    public void setLastName(String text){
        waitAndSendkeys(lastName,text);
    }

}
