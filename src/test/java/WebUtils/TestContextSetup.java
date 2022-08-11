package WebUtils;

import PageObjects.PageObjectManager;
import WebBase.BaseClass;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestContextSetup {
    public BaseClass baseClass;
    public WebDriver driver;
    public PageObjectManager pageObjectManager;

    public TestContextSetup() throws IOException {
        baseClass = new BaseClass();
        driver = baseClass.initializeDriver();
        pageObjectManager = new PageObjectManager(driver);
    }
}
