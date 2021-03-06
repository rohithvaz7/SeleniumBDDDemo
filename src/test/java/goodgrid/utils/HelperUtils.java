package goodgrid.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HelperUtils {

    private WebDriver driver;

    public HelperUtils(WebDriver driver){
        this.driver=driver;
    }

    public void implicitWait(int seconds){
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void explicitWait(int seconds, WebElement element){
        WebDriverWait wait=new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeEnabled(WebElement element) throws InterruptedException {
        int i=0;
        do{
            Thread.sleep(4000);
            if(element.isEnabled())
            break;
            i++;
        }
        while(!element.isEnabled() && i<5);
    }
}
