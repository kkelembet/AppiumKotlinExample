package hellocucumber

/**
 * Created by Ekaterina Kelembet on 02.01.2020.
 */

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.testng.Assert.assertTrue
import pages.SplashActivity
import util.Setup


class SplashStepsDefinition: Setup() {

    private val splashActivity = SplashActivity(driver!!)

    @Given("Splash activity")
    fun splashActivity() {
        assertTrue(splashActivity.isSplashScreenOpens())
    }

    @When("Tap by agree with privacy policy and terms of use")
    fun tapAgree() {
        splashActivity.agreeToPrivacyPolicyAndTermsOfUse()
    }

    @Then("Opens access for storage and location")
    fun accessOpens() {
        assertTrue(splashActivity.isAccessViewOpens())
    }
}