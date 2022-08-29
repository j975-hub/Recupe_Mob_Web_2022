package WebUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

public class AlternateClass {
    WebDriver driver;
    public AlternateClass(WebDriver driver){
        this.driver = driver;
    }
    public void setDate() throws InterruptedException {
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastName']"));
        driver.findElement(RelativeLocator.with(By.tagName("input")).below(lastName)).click();
        driver.findElement(By.xpath("(//div[@class='btn-light'])[15]")).click();
    }
}
