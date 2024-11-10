package com.polteq.workshop.steps;

import com.microsoft.playwright.*;
import com.polteq.workshop.context.ScenarioContext;
import com.polteq.workshop.lib.BrowserFactory;
import com.polteq.workshop.lib.BrowserName;
import com.polteq.workshop.pages.QuizPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Handles setup and teardown steps for Cucumber scenarios.
 */
public class BeforeAndAfterSteps extends CucumberScenario {

    private final ScenarioContext scenarioContext;
    private final Browser browser;
    private BrowserContext context;
    private Page page;

    /**
     * Initializes the BeforeAndAfterSteps with ScenarioContext and browser setup.
     *
     * @param scenarioContext the context holding data shared across steps
     */
    public BeforeAndAfterSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
        Playwright playwright = Playwright.create();
        this.browser = BrowserFactory.createBrowser(playwright, BrowserName.FIREFOX);
    }

    /**
     * Sets up the browser context and page before each scenario.
     *
     * @param scenario the Cucumber Scenario instance
     */
    @Before
    public void setUp(Scenario scenario) {
        CucumberScenario.scenario = scenario;
        initializeBrowserContext();
        setUpTracing();
        initializePage();
    }

    /**
     * Tears down the browser context and page after each scenario.
     *
     * @param scenario the Cucumber Scenario instance
     */
    @After
    public void tearDown(Scenario scenario) {
        captureScreenshot(scenario);
        closePage();
        stopTracing(scenario);
    }

    /**
     * Initializes a new browser context.
     */
    private void initializeBrowserContext() {
        this.context = browser.newContext();
    }

    /**
     * Configures tracing settings for the browser context.
     */
    private void setUpTracing() {
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));
    }

    /**
     * Initializes a new page and sets viewport size.
     */
    private void initializePage() {
        this.page = context.newPage();
        page.setViewportSize(1920, 1080);
        scenarioContext.quizPage = new QuizPage(page);
    }

    /**
     * Captures a screenshot and attaches it to the scenario.
     *
     * @param scenario the Cucumber Scenario instance
     */
    private void captureScreenshot(Scenario scenario) {
        byte[] screenshot = page.screenshot();
        scenario.attach(screenshot, "image/png", "screenshot.png");
    }

    /**
     * Closes the browser page.
     */
    private void closePage() {
        page.close();
    }

    /**
     * Stops tracing and logs the trace file path for the scenario.
     *
     * @param scenario the Cucumber Scenario instance
     */
    private void stopTracing(Scenario scenario) {
        String currentTestName = scenario.getName();
        Path storagePath = Paths.get("target/traces/" + currentTestName + ".zip");
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(storagePath));
        context.close();
        scenario.log("Trace file: " + storagePath.toAbsolutePath());
    }
}