package com.polteq.workshop.lib;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

/**
 * A factory class for creating browser instances using the Playwright framework.
 * This class provides methods to instantiate different types of browsers (Chromium, Firefox, WebKit)
 * with predefined launch options.
 */
public class BrowserFactory {

    private static final boolean headless = false;
    private static final double slowMo = 0;

    /**
     * Creates a browser instance using the specified Playwright instance and browser name.
     *
     * @param playwright  the Playwright instance used to create the browser
     * @param browserName the name of the browser to create (Chromium, Firefox, WebKit)
     * @return the created Browser instance
     */
    public static Browser createBrowser(Playwright playwright, BrowserName browserName) {
        return switch (browserName) {
            case CHROMIUM -> createChromiumBrowser(playwright);
            case FIREFOX -> createFirefoxBrowser(playwright);
            case WEBKIT -> createWebkitBrowser(playwright);
        };
    }

    /**
     * Creates a WebKit browser instance using the Playwright framework with predefined launch options.
     *
     * @param playwright The Playwright instance to use for launching the WebKit browser.
     * @return The launched WebKit browser instance.
     */
    private static Browser createWebkitBrowser(Playwright playwright) {
        return playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(headless).setSlowMo(slowMo));
    }

    /**
     * Creates a Firefox browser instance using the Playwright framework with predefined launch options.
     *
     * @param playwright The Playwright instance to use for launching the Firefox browser.
     * @return The launched Firefox browser instance.
     */
    private static Browser createFirefoxBrowser(Playwright playwright) {
        return playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(headless).setSlowMo(slowMo));
    }

    /**
     * Creates a Chromium browser instance using the Playwright framework with predefined launch options.
     *
     * @param playwright The Playwright instance to use for launching the Chromium browser.
     * @return The launched Chromium browser instance.
     */
    private static Browser createChromiumBrowser(Playwright playwright) {
        return playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless).setSlowMo(slowMo));
    }

}
