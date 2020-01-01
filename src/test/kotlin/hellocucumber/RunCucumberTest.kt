package hellocucumber

import io.cucumber.testng.CucumberOptions
import io.cucumber.testng.AbstractTestNGCucumberTests
import org.testng.annotations.Test

@Test
@CucumberOptions(
    features = ["src/test/resources/hellocucumber/is_it_friday_yet.feature:4"],
    plugin = ["pretty"]
)
class RunCucumberTest: AbstractTestNGCucumberTests()