package goodgrid.Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

import goodgrid.managers.PageObjectManager;
import goodgrid.managers.WebDriverManager;

/**
 * Created by Vineeth on 29/11/2019.
 */

public class BaseUtil {

    public static WebDriver Driver;

	public WebDriverManager webDriverManager;
    public PageObjectManager pageObjectManager;

    public ExtentReports extent;

    public static ExtentTest scenarioDef;

    public static ExtentTest features;

    public static String reportLocation = "SeleniumBDDPOC//report/";

    public BaseUtil(){
        Driver = webDriverManager.getDriver();
        pageObjectManager = new PageObjectManager(Driver);
    }

}
