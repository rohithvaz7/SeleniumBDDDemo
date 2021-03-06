package goodgrid.steps;

import goodgrid.Base.BaseUtil;
import goodgrid.managers.PageObjectManager;
import goodgrid.managers.WebDriverManager;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;


/**
 * Created by Vineeth on 29/11/2019.
 */

public class Hook extends BaseUtil{


    private BaseUtil base;
    public WebDriverManager webDriverManager;

    public Hook(BaseUtil base) {
        this.base = base;
        webDriverManager=new WebDriverManager();
    }


    @Before
    public void InitializeTest(Scenario scenario) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
        base.Driver = webDriverManager.getDriver();
        pageObjectManager = new PageObjectManager(base.Driver);
    }


    @After
    public void TearDownTest(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println(scenario.getName());
        }
        System.out.println("Closing the browser : MOCK");
        base.Driver.quit();
    }

    @BeforeStep
    public void BeforeEveryStep(Scenario scenario) {
        //System.out.println("Before every step " + scenario.getId());
    }

    @AfterStep
    public void AfterEveryStep(Scenario scenario) throws NoSuchFieldException, IllegalAccessException {
        //System.out.println("Before every step " + stepTestStep.getId());
    }

}
