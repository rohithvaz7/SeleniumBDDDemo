package goodgrid.steps;

import goodgrid.Base.BaseUtil;
import goodgrid.managers.FileReaderManager;
import goodgrid.pages.HomePage;
import goodgrid.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

/**
 * Created by Vineeth on 29/11/2019.
 */
public class LoginStep extends BaseUtil{

    HomePage home;
    LoginPage login;


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
        home.waitForGlobalIcon();
        System.out.println("Home Page successfully loaded");
        String actualTitle=home.getTitle();
        Assert.assertEquals("FindGood",actualTitle);
    }

    @Then("^I click on Global Icon and Create Action$")
    public void clickOnCreateAction() throws InterruptedException {
        home=pageObjectManager.getHomePage();
        home.clicKCreateAction();
        System.out.println("Clicked on Create Action Button");
    }

    @And("^pass Title Description AssignTo and AlsoVisibleTo parameters$")
    public void passCreateActionParameters(){
        home=pageObjectManager.getHomePage();
        home.passActionCreationParameters();
        System.out.println("All required Parameters are passed");
    }

    @And("^click on Save button$")
    public void clickSaveButton() throws InterruptedException {
        home=pageObjectManager.getHomePage();
        home.clickSave();
    }

    @Then("^Action is successfully saved and details are verified$")
    public void verifyDetailsOfTheCreatedAction() throws InterruptedException {
        home=pageObjectManager.getHomePage();
        home.verifyTheCreatedActionDetails();
    }

}
