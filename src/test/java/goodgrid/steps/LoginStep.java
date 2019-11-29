package goodgrid.steps;

import goodgrid.Base.BaseUtil;
import goodgrid.ConfigFileReader;
import goodgrid.managers.FileReaderManager;
import goodgrid.managers.PageObjectManager;

import com.aventstack.extentreports.GherkinKeyword;

import goodgrid.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import goodgrid.pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vineeth on 29/11/2019.
 */
public class LoginStep extends BaseUtil{

    HomePage home;
    LoginPage login=pageObjectManager.getLoginPage();


    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() throws Throwable {
        System.out.println("Navigate Login Page");
        login=pageObjectManager.getLoginPage();
        login.navigateToHomePage();
    }

    @When("^I pass username and password and click login$")
    public void iPassUserNameAndPassword() throws Throwable {
        login=pageObjectManager.getLoginPage();
        String username=FileReaderManager.getInstance().getConfigReader().getUserName();
        String password=FileReaderManager.getInstance().getConfigReader().getPassword();
        System.out.println("Enter Username and Password and click login");
        login.setUserNameTextBox(username);
        login.setPasswordTextBox(password);
        login.clickLogin();
        pageObjectManager.getHelperUtils().implicitWait(20);
    }

    @Then("^login should be successful and home page is displayed$")
    public void successfulLogin() throws Throwable {
        home=pageObjectManager.getHomePage();
        System.out.println("Navigate Login Page");
        home.waitForGlobalIcon();
        String actualTitle=home.getTitle();
        Assert.assertEquals("FindGood",actualTitle);
        home.clicKCreateAction();
    }

}
