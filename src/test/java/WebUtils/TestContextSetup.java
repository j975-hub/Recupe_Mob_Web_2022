package WebUtils;

import PageObjects.PageObjectManager;
import WebBase.BaseClass;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestContextSetup {
    public BaseClass baseClass;
    public WebDriver driver;
    public PageObjectManager pageObjectManager;

    public TestContextSetup() throws IOException {
        baseClass = new BaseClass();
        driver = baseClass.initializeDriver();
        pageObjectManager = new PageObjectManager(driver);
    }
    public JsonPath getJsonPath(String fileName) throws IOException {
    String pathName =  new String( Files.readAllBytes(Paths.get(".\\src\\test\\java\\JsonFiles\\"+fileName+".json")) );
    JsonPath jsonPath = new JsonPath(pathName);
     return jsonPath;

    }
}
