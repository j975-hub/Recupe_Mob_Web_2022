package WebUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class PageUtils {
    WebDriver driver;
    public PageUtils(WebDriver driver){
        this.driver=driver;
    }

    public void selectUserType(WebElement element,String text){
        highLightElement(driver,element);
        Select sc = new Select(element);
        sc.selectByVisibleText(text);
    }

    public WebElement waitAndSendkeys(WebElement element, Object value) {
        WebElement find;
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(12));
        find = wait.until(ExpectedConditions.visibilityOf(element));

        highLightElement(driver, element);
        if (value != null) {
            element.sendKeys(value.toString());
        }
        return find;
    }
    public void waitAndClick(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.visibilityOf(element)).click();
        highLightElement(driver,element);
        System.out.println(element.toString() + "is clicked sucessfully");
    }
    public static void highLightElement(WebDriver driver , WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')", element);
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){

        }
        js. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:white')", element);
    }
}
