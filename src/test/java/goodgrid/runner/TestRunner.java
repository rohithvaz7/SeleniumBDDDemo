package goodgrid.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * Created by Vineeth on 29/11/2019.
 */

@CucumberOptions(features = {"src/test/java/goodgrid/features"} ,
    plugin = {"json:target/cucumber.json","html:src/test/java/goodgrid/reports"},
    glue = "goodgrid/steps")
public class TestRunner extends AbstractTestNGCucumberTests {


    @Override
    @DataProvider
    //@DataProvider (parallel = true) -- For parallel execution support (which is not going to work for our code)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
