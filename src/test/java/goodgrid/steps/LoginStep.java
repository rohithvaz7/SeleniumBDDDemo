package goodgrid.steps;

import goodgrid.Base.BaseUtil;
import goodgrid.managers.PageObjectManager;

import com.aventstack.extentreports.GherkinKeyword;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import goodgrid.pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vineeth on 29/11/2019.
 */
public class LoginStep extends BaseUtil{

    public LoginStep(BaseUtil base) {
    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() throws Throwable {


        scenarioDef.createNode(new GherkinKeyword("Given"), "I navigate to the login page");
        System.out.println("Navigate Login Page");
        pageObjectManager.getLoginPage().navigateToHomePage();
    }


}
