package goodgrid.pages;

import goodgrid.utils.HelperUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(xpath="//a[@class='x-btn fg-plus-btn x-unselectable x-box-item x-toolbar-item x-btn-default-small']")
    WebElement globalIcon;

    @FindBy(xpath="//span[text()='Create an Action']")
    WebElement createActionButton;

    @FindBy(xpath="//input[@id='textfield-1151-inputEl']")
    WebElement actionTitle;

    @FindBy(xpath="//div[@id='cc-resource-assignto-1406-trigger-resources']")
    WebElement assignToDropDown;

    @FindBy(xpath="//span[contains(text(),'Friday org test']")
    WebElement assignToValue;

    @FindBy(xpath="(//div[contains(@id,'trigger-resources')])[2]")
    WebElement alsoVisibleToDropDown;

    @FindBy(xpath="(//div[@class='x-menu-item x-menu-item-default x-box-item']/a/span[text()='Me'])[2]/..")
    WebElement alsoVisibleToValue;

    @FindBy(xpath="//div[@class='x-tagfield x-form-field x-form-empty-field x-form-empty-field-default x-form-text x-form-text-default']")
    WebElement alsoVisibleToValue1;


    @FindBy(xpath="//html/head/style[@type='text/css']/../../body")
    WebElement description;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void waitForGlobalIcon(){
        new HelperUtils(driver).explicitWait(20,globalIcon);
    }

    public void clicKCreateAction() throws InterruptedException {
        globalIcon.click();
        createActionButton.click();
        new HelperUtils(driver).implicitWait(20);
        actionTitle.sendKeys("Sample Title");
        //assignToDropDown.click();
        //Thread.sleep(1000);
        //assignToValue.click();
        //alsoVisibleToDropDown.click();
        //new HelperUtils(driver).explicitWait(10,alsoVisibleToValue);
        //alsoVisibleToValue.click();
        alsoVisibleToValue1.sendKeys("Me");
        description.sendKeys("test");


    }
}
