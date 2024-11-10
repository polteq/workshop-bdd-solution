package com.polteq.workshop.steps;

import com.polteq.workshop.context.ScenarioContext;
import com.polteq.workshop.pages.QuizPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;

/**
 * This class defines the step definitions for interacting with the "Countries of the World Quiz"
 * during Cucumber testing scenarios. It extends the CucumberScenario class to inherit common
 * scenario-related functionalities.
 */
public class CountriesOfTheWorldSteps extends CucumberScenario {
    private final QuizPage quizPage;
    private final ScenarioContext scenarioContext;

    /**
     * Initializes a new instance of the CountriesOfTheWorldSteps class.
     *
     * @param scenarioContext an object that holds the context of the current testing scenario,
     *                        providing access to shared data and states among step definitions.
     */
    public CountriesOfTheWorldSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
        quizPage = scenarioContext.quizPage;
    }

    /**
     * Navigates to the "Countries of the World Quiz" website and accepts the cookie consent.
     * This method is typically used in the setup steps to ensure the web page is loaded and
     * cookies are accepted before any further interactions with the quiz.
     */
    @Given("I am on the Countries of the World Quiz website")
    public void iAmOnTheCountriesOfTheWorldQuizWebsite() {
        quizPage.navigateToQuizPage();
        quizPage.acceptCookieConsent();
    }

    /**
     * Initiates the process to start the quiz by fetching the list of countries
     * and then beginning the quiz.
     * <p>
     * This method retrieves the list of all country names available on the quiz
     * page and stores them in the scenario context. It then simulates a click on the
     * start button to begin the quiz.
     */
    @When("I start the quiz")
    public void iStartTheQuiz() {
        // Prepare the data, so we can achieve the best possible time in the quiz
        scenarioContext.countries = quizPage.getCountryList();
        quizPage.startQuiz();
    }

    /**
     * Fills in all the country names from the scenario context into the quiz page's input box.
     * This method iterates through the list of country names stored in the scenario context
     * and calls the fillInCountry method on the QuizPage object for each country name.
     */
    @And("I fill in all the countries of the world")
    public void iFillInAllTheCountriesOfTheWorld() {
        scenarioContext.countries.forEach(quizPage::fillInCountry);
    }

    /**
     * Verifies that all countries in the scenario context appear
     * correctly in the list on the quiz page.
     * Uses soft assertions to accumulate all assertion errors and
     * reports them at the end.
     */
    @Then("all the countries should appear in the list as correct")
    public void allTheCountriesShouldAppearInTheListAsCorrect() {
        SoftAssertions softAssertions = new SoftAssertions();
        for (String country : scenarioContext.countries) {
            softAssertions.assertThat(quizPage.isCountryCorrect(country))
                    .as("Country " + country + "should be in the list")
                    .isTrue();
        }
        softAssertions.assertAll();
    }
}
