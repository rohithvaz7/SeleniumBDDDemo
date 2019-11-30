package goodgrid.pages;

import goodgrid.utils.HelperUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    String titleName="Sample_Title_9";
    WebDriver driver;

    @FindBy(xpath="//a[@class='x-btn fg-plus-btn x-unselectable x-box-item x-toolbar-item x-btn-default-small']")
    WebElement globalIcon;

    @FindBy(xpath="//span[text()='Create an Action']")
    WebElement createActionButton;

    @FindBy(xpath="//input[@placeholder='Enter a Title for your Action']")
    WebElement actionTitle;

    @FindBy(xpath="(//div[contains(@id,'trigger-resources')])[1]")
    WebElement assignToDropDown;

    @FindBy(xpath="//a/span[contains(text(),'Friday org test')]")
    WebElement assignToValue;

    @FindBy(xpath="(//div[contains(@id,'trigger-resources')])[2]")
    WebElement alsoVisibleToDropDown;

    @FindBy(xpath="(//a/span[text()='Me'])[2]")
    WebElement alsoVisibleToValue;

    @FindBy(xpath=" //span[contains(text(),'Add a description for your Action')]")
    WebElement descriptiontextBox;

    @FindBy(xpath="//html/head/style[@type='text/css']/../../body")
    WebElement description;

    @FindBy(xpath="//iframe[contains(@id,'cc-custom')]")
    WebElement descriptionFrame;

    @FindBy(xpath="(//div[contains(@id,'trigger-picker')])[5]")
    WebElement statusSelection;

    @FindBy(xpath="//li[text()='Not Started']")
    WebElement statusDropDownValue;

    @FindBy(xpath="//span[text()='Yes']/../../..")
    WebElement closeModalYes;

    @FindBy(xpath="//span[text()='Save']/../../..")
    WebElement saveButton;

    @FindBy(xpath="(//i[@class='fa fa-chevron-down fg-expand'])[1]/..")
    WebElement expandIcon;

    @FindBy(xpath="(//span[@class='fg-user clickable'])[4]")
    WebElement assignedToVerify;

    @FindBy(xpath="(//span[@class='fg-user clickable'])[4]/../span[3]")
    WebElement alsoVisibleToVerify;

    @FindBy(xpath="(//span[@class='fg-user clickable'])[3]")
    WebElement titleVerification;


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
        Thread.sleep(5000);
        globalIcon.click();
        createActionButton.click();
        new HelperUtils(driver).explicitWait(20, actionTitle);
    }
    public void passActionCreationParameters() {
        actionTitle.sendKeys(titleName);
        assignToDropDown.click();
        new HelperUtils(driver).explicitWait(20, assignToValue);
        assignToValue.click();
        new HelperUtils(driver).implicitWait(20);
        alsoVisibleToDropDown.click();
        alsoVisibleToValue.click();
        new HelperUtils(driver).implicitWait(20);
        statusSelection.click();
        statusDropDownValue.click();
        new HelperUtils(driver).implicitWait(20);
        descriptiontextBox.click();
        driver.switchTo().frame(descriptionFrame);
        description.sendKeys("test");
        driver.switchTo().defaultContent();
        new HelperUtils(driver).implicitWait(20);
    }
    public void clickSave() throws InterruptedException {
        new HelperUtils(driver).waitForElementToBeEnabled(saveButton);
        saveButton.sendKeys(Keys.ENTER);
        System.out.println("Action Saved Succesfully");
        new HelperUtils(driver).implicitWait(20);
        closeModalYes.click();
    }

    public void verifyTheCreatedActionDetails() throws InterruptedException {
        Thread.sleep(5000);
        new HelperUtils(driver).explicitWait(20,expandIcon);
        expandIcon.click();
        Thread.sleep(5000);
        String actualAssignedTo=assignedToVerify.getText().trim();
        String actualTitleName=titleVerification.getText().trim();
        String actualAlsoVisibleTo=alsoVisibleToVerify.getText().trim();
        Assert.assertEquals("Friday org test",actualAssignedTo);
        Assert.assertEquals(titleName,actualTitleName);
        Assert.assertEquals("Me",actualAlsoVisibleTo);
        System.out.println("Created Action is verified accordingly");
    }
}
