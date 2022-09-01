package WebUtils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class PageUtils {
    WebDriver driver;
    public PageUtils(WebDriver driver){
        this.driver=driver;
    }

    protected void selectType(WebElement element,String text,String fileName) throws IOException {
        highLightElement(driver,element);
        Select sc = new Select(element);
        sc.selectByVisibleText(text);
        secreenShotOfWebelement(element,fileName);
    }

    protected WebElement waitAndSendkeys(WebElement element, Object value , String fileName) throws IOException {
        WebElement find;
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(12));
        find = wait.until(ExpectedConditions.visibilityOf(element));

        highLightElement(driver, element);
        if (value != null) {
            element.sendKeys(value.toString());
        }
        secreenShotOfWebelement(element,fileName);
        return find;
    }
    protected void waitAndClick(WebElement element, String fileName) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.visibilityOf(element)).click();
        secreenShotOfWebelement(element,fileName);
        highLightElement(driver,element);
        System.out.println(element.toString() + "is clicked sucessfully");

    }
    protected static void highLightElement(WebDriver driver , WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')", element);
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){

        }
        js. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:white')", element);
    }
    private void secreenShotOfWebelement(WebElement element,String fileName) throws IOException {
        File src = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File(".\\src\\test\\java\\ScreenshotsCollection\\"+fileName+".png"));
    }
}
