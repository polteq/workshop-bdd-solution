# Workshop for Hogeschool Windesheim - Countries of the World - BDD Solution

## Introduction
Tests the functionality of naming all countries in the JetPunk country quiz.

This test automates the process of opening the browser, navigating to the JetPunk
"How many countries can you name?" quiz, and verifying that all countries can be
correctly entered and marked as correct answers.

### Steps
1. Arrange: Set up the Playwright environment and browser, and navigate to the quiz page.
2. Act: Accept cookie consent, start the quiz, retrieve all country names, and enter each country into the answer box. Close any popups that appear.
3. Assert: Verify that all entered countries are marked as correct.
4. Cleanup: Close the Playwright browser and environment.

## Prerequisites
* IntelliJ Community Edition (or any other IDE like Eclipse, Visual Studio Code, etc.)
* JDK 21

## Extra info
There are 6 more files added to this exercise.
* `src/test/java/com/polteq/workshop/context/ScenarioContext.java`

The scenario context can hold information that different steps need to share. In this case the QuizPage object and the list of countries.

* `src/test/java/com/polteq/workshop/runners/CucumberRunnerTest.java`

A cucumber runner is the file that can iterate through all the .feature files to run them and also create reports.

* `src/test/java/com/polteq/workshop/steps/BeforeAndAfterSteps.java`

The Before and After steps had all the hooks needed to set up and tear down the browser and page objects.

* `src/test/java/com/polteq/workshop/steps/CountriesOfTheWorldSteps.java`

All the steps from the feature file are here translated into code.

* `src/test/java/com/polteq/workshop/steps/CucumberScenario.java`

The cucumber scenario is a class that cucumber uses to share scenario information

* `src/test/resources/features/CountriesOfTheWorld.feature`

This feature file describes the behaviour of the test. From here you can run the test. Cucumber will look up the steps in the stepdefinition file and run the code behind it.

## Exercise
* Fill in the code in `src/test/java/com/polteq/workshop/steps/CountriesOfTheWorldSteps.java` so that you can run the feature file.