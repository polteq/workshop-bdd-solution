package com.polteq.workshop.runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

/**
 * Test suite configuration for running Cucumber tests.
 * <p>
 * This class is annotated to define it as a test suite that includes the
 * Cucumber test engine and selects feature files from the classpath.
 * <p>
 * Configuration parameters:
 * - GLUE_PROPERTY_NAME: Specifies the package to look for step definitions.
 * - PLUGIN_PROPERTY_NAME: Configures output formats and target locations for test reports.
 * - PLUGIN_PUBLISH_QUIET_PROPERTY_NAME: Controls the visibility of publishing information in the output.
 */
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.polteq.workshop.steps")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,json:target/cucumber.json,html:target/cucumber-reports/cucumber.html")
@ConfigurationParameter(key = PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true")
public class CucumberRunnerTest {
}
