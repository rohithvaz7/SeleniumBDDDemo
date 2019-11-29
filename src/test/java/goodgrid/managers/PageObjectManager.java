package goodgrid.managers;

import goodgrid.pages.HomePage;
import goodgrid.utils.HelperUtils;
import org.openqa.selenium.WebDriver;

import goodgrid.pages.LoginPage;

public class PageObjectManager {

    private WebDriver driver;

    private LoginPage loginPage;
    private HomePage homePage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;

    }

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;

    }

    public HelperUtils getHelperUtils() {
        return new HelperUtils(driver);

    }
}
