package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber",glue="com.company.stepefinitionsimpl",monochrome=true,plugin="html:test-output/cucumberrEport.html")
public class TestNGRunner extends AbstractTestNGCucumberTests 
{

}
