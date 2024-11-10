package com.polteq.workshop.pages;

import com.microsoft.playwright.Page;

/**
 * BasePage serves as an abstract base class for web page interactions.
 * It provides a foundational structure for specific page objects to extend.
 */
public abstract class BasePage {
    /**
     * Represents a web page instance used by the BasePage class.
     * The page object is an abstraction of a web page, facilitating interactions and operations on the web page.
     * This variable is initialized during the construction of a BasePage instance and provides the context for various page actions.
     */
    protected final Page page;

    /**
     * Constructs a new instance of the BasePage class.
     *
     * @param page the WebDriver instance to be used by the BasePage
     */
    public BasePage(Page page) {
        this.page = page;
    }
}
