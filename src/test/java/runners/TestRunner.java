package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/resources/features", glue= "stepdefinations" , tags="@smoke")
public class TestRunner extends AbstractTestNGCucumberTests{
	
	

}
