package hellocucumber

import io.cucumber.testng.CucumberOptions
import org.testng.annotations.Test
import io.cucumber.testng.AbstractTestNGCucumberTests

@Test
@CucumberOptions(features = ["/AppiumKotlinExample/src/test/resources/hellocucumber/splash_screen.feature"], glue = ["hellocucumber"])
class RunCucumberTest : AbstractTestNGCucumberTests()