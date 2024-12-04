package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/feature",glue="Stepdefination",monochrome=true)
public class Cucumbertestngtestrunner extends AbstractTestNGCucumberTests {
	
	

}
