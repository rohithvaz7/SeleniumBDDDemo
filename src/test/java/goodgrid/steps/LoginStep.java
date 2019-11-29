package goodgrid.steps;

import goodgrid.Base.BaseUtil;
import goodgrid.ConfigFileReader;
import goodgrid.managers.FileReaderManager;
import goodgrid.managers.PageObjectManager;

import com.aventstack.extentreports.GherkinKeyword;

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

    /*public LoginStep(BaseUtil base) {
    }*/


    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() throws Throwable {
        System.out.println("Navigate Login Page");
        pageObjectManager.getLoginPage().navigateToHomePage();
    }

    @When("^I pass username and password and click login$")
    public void iPassUserNameAndPassword() throws Throwable {
        String username=FileReaderManager.getInstance().getConfigReader().getUserName();
        String password=FileReaderManager.getInstance().getConfigReader().getPassword();
        System.out.println("Enter Username and Password and click login");
        pageObjectManager.getLoginPage().setUserNameTextBox(username);
        pageObjectManager.getLoginPage().setPasswordTextBox(password);
        pageObjectManager.getLoginPage().clickLogin();
        pageObjectManager.getHelperUtils().implicitWait(20);
    }

    @Then("^login should be successful and home page is displayed$")
    public void successfulLogin() throws Throwable {
        System.out.println("Navigate Login Page");
        pageObjectManager.getHomePage().waitForGlobalIcon();
        String actualTitle=pageObjectManager.getHomePage().getTitle();
        Assert.assertEquals("FindGood",actualTitle);
        pageObjectManager.getHomePage().clicKCreateAction();
    }

}
