package hellocucumber

import io.cucumber.testng.CucumberOptions
import org.testng.annotations.Test
import io.cucumber.testng.AbstractTestNGCucumberTests

@Test
@CucumberOptions(features = ["/AppiumKotlinExample/src/test/resources/hellocucumber/is_it_friday_yet.feature"], glue = ["hellocucumber"])
class RunCucumberTest : AbstractTestNGCucumberTests()