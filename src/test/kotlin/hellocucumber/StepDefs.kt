package hellocucumber

import io.cucumber.java.en.Then
import io.cucumber.java.en.Given
import io.cucumber.java.en.When
import org.testng.Assert.assertEquals

fun isItFriday(today: String) = "Nope"


class StepDefs {
    private lateinit var today: String
    private lateinit var actualAnswer: String

    @Given("today is Sunday")
    fun today_is_Sunday() {
        today = "Sunday"
    }

    @When("I ask whether it's Friday yet")
    fun i_ask_whether_it_s_Friday_yet() {
        actualAnswer = isItFriday(today)
    }

    @Then("I should be told {string}")
    fun i_should_be_told(expectedAnswer: String) {
        assertEquals(expectedAnswer, actualAnswer)
    }
}