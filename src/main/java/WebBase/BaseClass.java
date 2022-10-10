package WebBase;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BaseClass {

    public  WebDriver driver;
    private FileInputStream fis;
    public Properties prop ;
    public Logger log;

    public WebDriver initializeDriver() throws IOException {
        try {
            log = LogManager.getLogger(BaseClass.class.getName());
            prop = new Properties();
            fis = new FileInputStream(".\\src\\test\\resources\\Configuration\\config.properties");
            Assert.assertNotNull(fis, "config.properties file not loaded");
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exception is ==" + e.getMessage());
        }
        String browserName = prop.getProperty("browser");

        switch (browserName) {
            case Constants.CHROME:
            if(driver == null) {
                System.out.println("----------"+browserName+"-------");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get(prop.getProperty("STAGE_URL"));
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
//            case Constants.FIREFOX:
//                System.out.println("----------"+browserName+"-------");
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();
//            case Constants.IE:
//                System.out.println("----------"+browserName+"-------");
//                WebDriverManager.iedriver().setup();
//                driver = new InternetExplorerDriver();
        }
        return  driver;
    }




}
