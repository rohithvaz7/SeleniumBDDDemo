package goodgrid.pages;

import goodgrid.utils.HelperUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

    @FindBy(xpath="//input[@placeholder='Enter a Title for your Action']")
    WebElement actionTitle;

    @FindBy(xpath="//div[@id='cc-resource-assignto-1406-trigger-resources']")
    WebElement assignToDropDown;

    @FindBy(xpath="//span[contains(text(),'Friday org test']")
    WebElement assignToValue;

    @FindBy(xpath="(//div[contains(@id,'trigger-resources')])[2]")
    WebElement alsoVisibleToDropDown;

    @FindBy(xpath="(//div[@class='x-menu-item x-menu-item-default x-box-item']/a/span[text()='Me'])[2]/..")
    WebElement alsoVisibleToValue;

    @FindBy(xpath="//a/span[text()='Me']")
    WebElement alsoVisibleToValue1;


    @FindBy(xpath=" //span[contains(text(),'Add a description for your Action')]")
    WebElement descriptiontextBox;

    @FindBy(xpath="//html/head/style[@type='text/css']/../../body")
    WebElement description;

    @FindBy(xpath="//iframe[contains(@id,'cc-custom')]")
    WebElement descriptionFrame;

    @FindBy(xpath="//span[text()='Save']/../../..")
    WebElement saveButton;



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
        new HelperUtils(driver).explicitWait(20,actionTitle);
        actionTitle.sendKeys("Sample Title_1");
        //assignToDropDown.click();
        //assignToValue.click();
        alsoVisibleToDropDown.click();
        alsoVisibleToValue1.click();
        Thread.sleep(3000);
        descriptiontextBox.click();
        driver.switchTo().frame(descriptionFrame);
        description.sendKeys("test");
        driver.switchTo().defaultContent();
        Thread.sleep(8000);
        new HelperUtils(driver).waitForElementToBeEnabled(saveButton);
        saveButton.sendKeys(Keys.ENTER);
        System.out.println("Action Saved Succesfully");
        Thread.sleep(5000);
    }
}
