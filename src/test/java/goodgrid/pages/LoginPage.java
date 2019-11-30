package goodgrid.pages;

import goodgrid.managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Vineeth on 29/11/2019.
 */
public class LoginPage {
    WebDriver driver;


    @FindBy(xpath="//input[@id='loginForm:username']")
    WebElement userNameTextBox;

    @FindBy(xpath="//input[@id='loginForm:password']")
    WebElement passwordTextBox;

    @FindBy(xpath="//input[@id='loginForm:loginButton']")
    WebElement loginButton;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToHomePage(){
        driver.manage().window().maximize();
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }

    public void setUserNameTextBox(String userName) {
        userNameTextBox.sendKeys(userName);
    }

    public void setPasswordTextBox(String password) {
        passwordTextBox.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }



}
